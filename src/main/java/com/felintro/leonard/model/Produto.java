package com.felintro.leonard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "ds_descricao", nullable = false)
    private String descricao;

    @Column(name = "cd_barras_unidade", nullable = false, length = 13)
    private String codigoBarrasUn;

    @Column(name = "cd_barras_container", nullable = false, length = 14)
    private String codigoBarrasCx;

    @Column(name = "fator_container", nullable = false)
    private Integer fatorContainer;

}
