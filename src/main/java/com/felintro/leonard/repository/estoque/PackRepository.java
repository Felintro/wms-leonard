package com.felintro.leonard.repository.estoque;

import com.felintro.leonard.model.estoque.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author allan
 **/

@Repository
public interface PackRepository extends JpaRepository<Pack, Long> {

    @Query("SELECT p FROM Pack p WHERE p.nrPack NOT IN (SELECT e.pack.nrPack FROM Endereco e)")
    List<Pack> findAllPacksWithoutEndereco();

}