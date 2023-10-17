package com.felintro.leonard.model.estoque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
public class Produto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ds_descricao", nullable = false)
    private String descricao;

    @Column(name = "nr_ean13", nullable = false, length = 13)
    private String nrEan13;

    @Column(name = "nr_dun14", nullable = false, length = 14)
    private String nrDun14;

    @Column(name = "fator_caixa", nullable = false)
    private int fatorCaixa;

    public Produto(String descricao, String nrEan13, String nrDun14, int fatorCaixa) {
        this.descricao = descricao;
        this.nrEan13 = nrEan13;
        this.nrDun14 = nrDun14;
        this.fatorCaixa = fatorCaixa;
    }
}
