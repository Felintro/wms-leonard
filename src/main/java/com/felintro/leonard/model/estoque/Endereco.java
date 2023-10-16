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
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nr_rua", nullable = false)
    private int numeroRua;

    @Column(name = "nr_predio", nullable = false)
    private int numeroPredio;

    @Column(name = "nr_apartamento", nullable = false)
    private int numeroApartamento;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.numeroRua)
            .append(".")
            .append(this.numeroPredio)
            .append(".")
            .append(this.numeroApartamento);

        return sb.toString();
    }
}
