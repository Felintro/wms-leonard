package com.felintro.leonard.repository;

import com.felintro.leonard.model.operacao.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author allan
 **/

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}