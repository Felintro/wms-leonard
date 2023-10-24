package com.felintro.leonard.repository.pessoa;

import com.felintro.leonard.model.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author allan
 **/

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}