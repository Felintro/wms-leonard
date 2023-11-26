package com.felintro.leonard.business.operacao;

import com.felintro.leonard.dto.operacao.SepararProdutoDTO;
import com.felintro.leonard.enums.StatusOperacao;
import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.model.estoque.Container;
import com.felintro.leonard.model.estoque.ContainerProduto;
import com.felintro.leonard.model.estoque.Pack;
import com.felintro.leonard.model.estoque.Produto;
import com.felintro.leonard.model.operacao.Recebimento;
import com.felintro.leonard.model.operacao.Separacao;
import com.felintro.leonard.model.pedido.Pedido;
import com.felintro.leonard.model.pedido.PedidoProduto;
import com.felintro.leonard.repository.estoque.ContainerRepository;
import com.felintro.leonard.repository.estoque.ProdutoRepository;
import com.felintro.leonard.repository.operacao.SeparacaoRepository;
import com.felintro.leonard.repository.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public boolean separarProduto(SepararProdutoDTO separarProdutoDTO) {
        boolean isOperacaoFinalizada = false;

        Optional<Separacao> optSeparacao = buscarPorNrPedido(separarProdutoDTO.getNrPedido());
        Separacao separacao = optSeparacao.orElseGet(Separacao::new);
        Container container;
        Produto produto = produtoRepository.findByNrEan13(separarProdutoDTO.getNrEan13());
        Pedido pedido = pedidoRepository.getReferenceById(separarProdutoDTO.getNrPedido());

        if(optSeparacao.isEmpty()){
            separacao.setStatusOperacao(StatusOperacao.EM_ANDAMENTO);
            separacao.setPedido(pedido);
            container = new Container();
        } else {
            container = containerRepository.findById(separarProdutoDTO.getNrContainer()).get();
        }

        ContainerProduto containerProduto = new ContainerProduto(produto, separarProdutoDTO.getQtdeSeparada());
        container.adicionarProduto(containerProduto);

        int qtdeTotalSeparada = separacao.getContainerList()
            .stream()
            .flatMap(containerSeparado -> containerSeparado.getProdutos().stream())
            .mapToInt(ContainerProduto::getQuantidade)
            .sum();

        int qtdeTotalPedido = pedido.getProdutos()
            .stream()
            .mapToInt(PedidoProduto::getQuantidade)
            .sum();

        if(qtdeTotalSeparada == qtdeTotalPedido) {
            separacao.setStatusOperacao(StatusOperacao.CONCLUIDA);
            separacao.getPedido().setStatusPedido(StatusPedido.CONCLUIDO);
            isOperacaoFinalizada = true;
        }

        separacao.setDtHrRealizacao(LocalDateTime.now());
        separacao.getContainerList().add(container);
        separacaoRepository.save(separacao);

        return isOperacaoFinalizada;
    }

    public Optional<Separacao> buscarPorNrPedido(Long nrPedido) {
        return separacaoRepository.findSeparacaoByPedidoNrPedido(nrPedido);
    }

}