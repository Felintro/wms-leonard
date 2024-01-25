package com.felintro.leonard.repository.operacao;

import com.felintro.leonard.model.operacao.Expedicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author allan
 **/

@Repository
public interface ExpedicaoRepository extends JpaRepository<Expedicao, Long> {

}