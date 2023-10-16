package com.felintro.leonard.model.autenticacao;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "uuid")
    private UUID uuid;


    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    @ManyToMany
    private List<Permissao> permissoes;

}
