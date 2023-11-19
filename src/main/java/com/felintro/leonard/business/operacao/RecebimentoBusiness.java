package com.felintro.leonard.business.operacao;

import com.felintro.leonard.dto.operacao.ReceberProdutoDTO;
import com.felintro.leonard.enums.StatusOperacao;
import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.model.estoque.Pack;
import com.felintro.leonard.model.estoque.Produto;
import com.felintro.leonard.model.operacao.Recebimento;
import com.felintro.leonard.model.pedido.Pedido;
import com.felintro.leonard.model.pedido.PedidoProduto;
import com.felintro.leonard.repository.estoque.PackRepository;
import com.felintro.leonard.repository.estoque.ProdutoRepository;
import com.felintro.leonard.repository.operacao.RecebimentoRepository;
import com.felintro.leonard.repository.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author allan
 **/

@Service
public class RecebimentoBusiness {

    @Autowired
    private PackRepository packRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private RecebimentoRepository recebimentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    public boolean receberProduto(ReceberProdutoDTO receberProdutoDTO) {
        boolean isOperacaoFinalizada = false;

        Optional<Recebimento> optRecebimento = buscarPorNrPedido(receberProdutoDTO.getNrPedido());
        Recebimento recebimento = optRecebimento.orElseGet(Recebimento :: new);

        Produto produto = produtoRepository.findByNrEan13(receberProdutoDTO.getNrEan13());
        Pack pack = new Pack(receberProdutoDTO.getNrPack(), produto, receberProdutoDTO.getQtdeRecebida());

        Pedido pedido = pedidoRepository.getReferenceById(receberProdutoDTO.getNrPedido());

        if(optRecebimento.isEmpty()){
            recebimento.setStatusOperacao(StatusOperacao.EM_ANDAMENTO);
            recebimento.setPedido(pedido);
        }

        recebimento.setDtHrRealizacao(LocalDateTime.now());
        recebimento.getPackList().add(pack);

        int qtdeTotalRecebida = recebimento.getPackList()
            .stream()
            .mapToInt(Pack :: getQuantidade)
            .sum();

        int qtdeTotalPedido = pedido.getProdutos()
            .stream()
            .mapToInt(PedidoProduto :: getQuantidade)
            .sum();

        if(qtdeTotalRecebida == qtdeTotalPedido) {
            recebimento.setStatusOperacao(StatusOperacao.CONCLUIDA);
            recebimento.getPedido().setStatusPedido(StatusPedido.RECEBIDO);
            isOperacaoFinalizada = true;
        }

        recebimentoRepository.save(recebimento);

        return isOperacaoFinalizada;

    }

    public void estornarProduto(Long nrPedido, Long nrPack, String nrEan13) {

    }

    public Optional<Recebimento> buscarPorNrPedido(Long nrPedido) {
       return recebimentoRepository.findRecebimentoByPedidoNrPedido(nrPedido);
    }

}