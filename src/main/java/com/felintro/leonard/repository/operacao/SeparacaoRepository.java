package com.felintro.leonard.repository.operacao;

import com.felintro.leonard.model.operacao.Separacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author allan
 **/

@Repository
public interface SeparacaoRepository extends JpaRepository<Separacao, Long> {

    Optional<Separacao> findSeparacaoByPedidoNrPedido(Long nrPedido);

}