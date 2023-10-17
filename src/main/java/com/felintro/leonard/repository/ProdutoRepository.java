package com.felintro.leonard.repository;

import com.felintro.leonard.model.estoque.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
