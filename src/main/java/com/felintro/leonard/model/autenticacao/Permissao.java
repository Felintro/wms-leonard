package com.felintro.leonard.model.autenticacao;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "permissao")
@Data
@NoArgsConstructor
public class Permissao {

    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "ds_permissao", nullable = false)
    private String nome;

    public Permissao(UUID uuid) {
        this.uuid = uuid;
    }
}