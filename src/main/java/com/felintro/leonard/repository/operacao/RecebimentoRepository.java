package com.felintro.leonard.repository.operacao;

import com.felintro.leonard.model.operacao.Recebimento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author allan
 **/

public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {

    Recebimento findRecebimentoByPedidoNrPedido(Long nrPedido);

}