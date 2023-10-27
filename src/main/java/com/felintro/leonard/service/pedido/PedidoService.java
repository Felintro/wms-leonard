package com.felintro.leonard.service.pedido;

import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.model.pedido.Pedido;
import com.felintro.leonard.repository.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoDTO> listarPorTipo(TipoPedido tipoPedido) {
        List<Pedido> pedidos = pedidoRepository.findByTipoPedido(tipoPedido);
        return getPedidoDTOS(pedidos);
    }

    public List<PedidoDTO> listarTodos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return getPedidoDTOS(pedidos);
    }

    public void cadastrarPedido(PedidoDTO pedidoDTO) {
        var pedido = pedidoDTO.toEntity();
        pedidoRepository.save(pedido);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public PedidoDTO buscarPorNrPedido(Long nrPedido) {
        return pedidoRepository.getReferenceById(nrPedido).toDTO();
    }


    private List<PedidoDTO> getPedidoDTOS(List<Pedido> pedidos) {
        List<PedidoDTO> retorno = new ArrayList<>();
        pedidos.forEach(pedido -> retorno.add(pedido.toDTO()));
        return retorno;
    }

}