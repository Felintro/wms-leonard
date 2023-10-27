package com.felintro.leonard.repository.estoque;

import com.felintro.leonard.model.estoque.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    boolean existsByNrEan13AndNrDun14(String nrEan13, String nrDun14);

    Produto findByNrEan13(String nrEan13);

    Produto findByNrDun14(String nrDun14);

}