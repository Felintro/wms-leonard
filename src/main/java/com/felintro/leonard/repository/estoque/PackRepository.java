package com.felintro.leonard.repository.estoque;

import com.felintro.leonard.model.estoque.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author allan
 **/

@Repository
public interface PackRepository extends JpaRepository<Pack, Long> {

}