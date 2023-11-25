package com.felintro.leonard.repository.pedido;

import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.model.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author allan
 **/

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByTipoPedido(TipoPedido tipoPedido);

    List<Pedido> findByStatusPedidoAndTipoPedido(StatusPedido statusPedido, TipoPedido tipoPedido);

}