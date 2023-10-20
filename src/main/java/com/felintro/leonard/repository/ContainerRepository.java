package com.felintro.leonard.repository;

import com.felintro.leonard.model.estoque.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author allan
 **/
@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

}