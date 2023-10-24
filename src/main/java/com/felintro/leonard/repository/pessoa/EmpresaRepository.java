package com.felintro.leonard.repository.pessoa;

import com.felintro.leonard.model.pessoa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author allan
 **/

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}