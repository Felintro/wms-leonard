package com.felintro.leonard.repository;

import com.felintro.leonard.model.estoque.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author allan
 **/
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
