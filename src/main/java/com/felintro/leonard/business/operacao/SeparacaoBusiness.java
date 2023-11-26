package com.felintro.leonard.business.operacao;

import com.felintro.leonard.model.operacao.Separacao;
import com.felintro.leonard.repository.estoque.ContainerRepository;
import com.felintro.leonard.repository.estoque.ProdutoRepository;
import com.felintro.leonard.repository.operacao.SeparacaoRepository;
import com.felintro.leonard.repository.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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





    public Optional<Separacao> buscarPorNrPedido(Long nrPedido) {
        return separacaoRepository.findSeparacaoByPedidoNrPedido(nrPedido);
    }
}