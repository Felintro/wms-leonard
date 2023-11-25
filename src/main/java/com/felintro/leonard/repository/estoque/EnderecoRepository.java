package com.felintro.leonard.repository.estoque;

import com.felintro.leonard.model.estoque.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author allan
 **/
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Endereco findByNrRuaAndNrPredioAndNrApartamento(int nrRua, int nrPredio, int nrApartamento);

    boolean existsByNrRuaAndNrPredioAndNrApartamento(int nrRua, int nrPredio, int nrApartamento);

    @Query("SELECT e FROM Endereco e WHERE e.pack.nrPack = ?1")
    Optional<Endereco> findByNrPack(Long nrPack);

}