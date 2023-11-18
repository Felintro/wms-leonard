package com.felintro.leonard.service.pedido;

import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.dto.pedido.PedidoProdutoDTO;
import com.felintro.leonard.dto.pedido.RegistraPedidoDTO;
import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.model.estoque.Produto;
import com.felintro.leonard.model.pedido.Pedido;
import com.felintro.leonard.model.pedido.PedidoProduto;
import com.felintro.leonard.model.pessoa.Empresa;
import com.felintro.leonard.repository.estoque.ProdutoRepository;
import com.felintro.leonard.repository.pedido.PedidoRepository;
import com.felintro.leonard.repository.pessoa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<PedidoDTO> listarPorTipo(TipoPedido tipoPedido) {
        List<Pedido> pedidos = pedidoRepository.findByTipoPedido(tipoPedido);
        return geraPedidoDTOS(pedidos);
    }

    public List<PedidoDTO> listarTodos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return geraPedidoDTOS(pedidos);
    }

    public PedidoDTO buscarPorNrPedido(Long nrPedido) {
        return pedidoRepository.getReferenceById(nrPedido).toDTO();
    }

    public List<PedidoProdutoDTO> buscarProdutosPorNrPedido(Long nrPedido) {
        return pedidoRepository.getReferenceById(nrPedido).toDTO().getProdutosDTO();
    }

    public List<PedidoDTO> buscarPorStatusETipo(StatusPedido statusPedido, TipoPedido tipoPedido) {
        List<Pedido> pedidos = pedidoRepository.findByStatusPedidoAndTipoPedido(statusPedido, tipoPedido);
        return geraPedidoDTOS(pedidos);
    }

    public PedidoDTO registrarPedido(RegistraPedidoDTO registraPedidoDTO) {
        Empresa empresa = empresaRepository.findByNrCnpj(registraPedidoDTO.getNrCnpj());
        Pedido pedido = new Pedido(empresa, registraPedidoDTO.getTipoPedido());
        registraPedidoDTO.getProdutos()
            .forEach(registraProdutoPedidoCompraDTO -> {
                Produto produto = produtoRepository.findByNrEan13(registraProdutoPedidoCompraDTO.getNrEan13());
                PedidoProduto pedidoProduto = new PedidoProduto(produto, registraProdutoPedidoCompraDTO.getQtde());
                pedido.adicionarProduto(pedidoProduto);
            }
        );
        pedido.setDtHrEmissao(LocalDateTime.now());
        pedido.setStatusPedido(StatusPedido.ABERTO);
        Pedido pedidoAtualizado = pedidoRepository.save(pedido);
        return pedidoAtualizado.toDTO();
    }

    public PedidoDTO cancelarPedido(Long nrPedido) {
        Pedido pedido = pedidoRepository.getReferenceById(nrPedido);
        pedido.setStatusPedido(StatusPedido.CANCELADO);
        return pedido.toDTO();
    }

    private List<PedidoDTO> geraPedidoDTOS(List<Pedido> pedidos) {
        List<PedidoDTO> retorno = new ArrayList<>();
        pedidos.forEach(pedido -> retorno.add(pedido.toDTO()));
        return retorno;
    }

}