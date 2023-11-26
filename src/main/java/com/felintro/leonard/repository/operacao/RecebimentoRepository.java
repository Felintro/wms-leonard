package com.felintro.leonard.repository.operacao;

import com.felintro.leonard.model.operacao.Recebimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author allan
 **/
@Repository
public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {

    Optional<Recebimento> findRecebimentoByPedidoNrPedido(Long nrPedido);

}