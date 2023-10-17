package com.felintro.leonard.repository;

import com.felintro.leonard.model.autenticacao.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

}
