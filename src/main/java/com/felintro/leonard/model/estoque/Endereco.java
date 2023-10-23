package com.felintro.leonard.model.estoque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nr_rua", nullable = false)
    private int numeroRua;

    @Column(name = "nr_predio", nullable = false)
    private int numeroPredio;

    @Column(name = "nr_apartamento", nullable = false)
    private int numeroApartamento;

    @OneToOne
    @JoinColumn(name = "nr_container")
    private Container container;

    public Endereco(int numeroRua, int numeroPredio, int numeroApartamento) {
        this.numeroRua = numeroRua;
        this.numeroPredio = numeroPredio;
        this.numeroApartamento = numeroApartamento;
        this.container = null;
    }

    public String getEnderecoCompleto() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.numeroRua)
            .append(".")
            .append(this.numeroPredio)
            .append(".")
            .append(this.numeroApartamento);

        return sb.toString();
    }

    public boolean isVazio() {
        return this.container == null;
    }

}