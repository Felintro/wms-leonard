package com.felintro.leonard.business.operacao;

import com.felintro.leonard.dto.operacao.FinalizarContainerDTO;
import com.felintro.leonard.dto.operacao.SepararProdutoDTO;
import com.felintro.leonard.enums.StatusOperacao;
import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.model.estoque.Container;
import com.felintro.leonard.model.estoque.ContainerProduto;
import com.felintro.leonard.model.estoque.Endereco;
import com.felintro.leonard.model.estoque.Produto;
import com.felintro.leonard.model.operacao.Separacao;
import com.felintro.leonard.model.pedido.Pedido;
import com.felintro.leonard.model.pedido.PedidoProduto;
import com.felintro.leonard.repository.estoque.ContainerRepository;
import com.felintro.leonard.repository.estoque.EnderecoRepository;
import com.felintro.leonard.repository.estoque.ProdutoRepository;
import com.felintro.leonard.repository.operacao.SeparacaoRepository;
import com.felintro.leonard.repository.pedido.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * @author allan
 **/

@Service
public class SeparacaoBusiness {

    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private SeparacaoRepository separacaoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void separarProduto(SepararProdutoDTO separarProdutoDTO) {
        Optional<Separacao> optSeparacao = buscarPorNrPedido(separarProdutoDTO.getNrPedido());
        Separacao separacao = optSeparacao.orElseGet(Separacao::new);
        Container container;
        Produto produto = produtoRepository.findByNrEan13(separarProdutoDTO.getNrEan13());
        Pedido pedido = pedidoRepository.getReferenceById(separarProdutoDTO.getNrPedido());

        if(optSeparacao.isEmpty()){
            separacao.setStatusOperacao(StatusOperacao.EM_ANDAMENTO);
            separacao.setPedido(pedido);
            container = new Container(separarProdutoDTO);
        } else {
            container = containerRepository.findById(separarProdutoDTO.getNrContainer()).get();
        }

        ContainerProduto containerProduto = new ContainerProduto(produto, separarProdutoDTO.getQtdeSeparada());
        container.adicionarProduto(containerProduto);

        containerRepository.save(container);

        if(!separacao.getContainerList().contains(container)) {
            separacao.getContainerList().add(container);
        }

        separacao.setDtHrRealizacao(LocalDateTime.now());
        separacaoRepository.save(separacao);
    }

    public boolean finalizarContainer(FinalizarContainerDTO finalizarContainerDTO) {
        boolean isOperacaoFinalizada = false;
        Separacao separacao = separacaoRepository.findSeparacaoByPedidoNrPedido(finalizarContainerDTO.getNrPedidoSeparacao()).orElseThrow(EntityNotFoundException::new);
        Container containerFinalizado = containerRepository.findById(finalizarContainerDTO.getNrContainerFinalizar()).orElseThrow(EntityNotFoundException::new);
        Pedido pedido = pedidoRepository.findById(finalizarContainerDTO.getNrPedidoSeparacao()).orElseThrow(EntityNotFoundException::new);
        Endereco enderecoFinalizacao = enderecoRepository.findByNrRuaAndNrPredioAndNrApartamento(finalizarContainerDTO.getNrRuaFinalizar(), finalizarContainerDTO.getNrPredioFinalizar(), finalizarContainerDTO.getNrApartamentoFinalizar());

        containerFinalizado.setEndereco(enderecoFinalizacao);
        containerRepository.save(containerFinalizado);

        boolean isConteineresFinalizados = separacao.getContainerList().stream()
            .map(Container::getEndereco)
            .allMatch(Objects::nonNull);

        int qtdeSeparada = separacao.getContainerList().stream()
            .mapToInt(Container::getQuantidadeTotal)
            .sum();

        int qtdePedido = pedido.getProdutos().stream()
            .mapToInt(PedidoProduto::getQuantidade)
            .sum();

        boolean isQtdeTotalSeparada = qtdeSeparada == qtdePedido;

        if(isConteineresFinalizados && isQtdeTotalSeparada) {
            separacao.setStatusOperacao(StatusOperacao.CONCLUIDA);
            separacao.getPedido().setStatusPedido(StatusPedido.CONCLUIDO);
            isOperacaoFinalizada = true;
        }

        return isOperacaoFinalizada;
    }

    public Optional<Separacao> buscarPorNrPedido(Long nrPedido) {
        return separacaoRepository.findSeparacaoByPedidoNrPedido(nrPedido);
    }

}