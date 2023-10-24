package com.felintro.leonard.repository.estoque;

import com.felintro.leonard.model.estoque.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author allan
 **/
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Endereco findByNrRuaAndNrPredioAndNrApartamento(int nrRua, int nrPredio, int nrApartamento);

    boolean existsByNrRuaAndNrPredioAndNrApartamento(int nrRua, int nrPredio, int nrApartamento);


}
