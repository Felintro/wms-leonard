package com.felintro.leonard.model.estoque;

import com.felintro.leonard.dto.estoque.EnderecoDTO;
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
    private int nrRua;

    @Column(name = "nr_predio", nullable = false)
    private int nrPredio;

    @Column(name = "nr_apartamento", nullable = false)
    private int nrApartamento;

    @OneToOne
    @JoinColumn(name = "nr_container")
    private Container container;

    public Endereco(int numeroRua, int nrPredio, int numeroApartamento, Container container) {
        this.nrRua = numeroRua;
        this.nrPredio = nrPredio;
        this.nrApartamento = numeroApartamento;
        this.container = container;
    }

    public String getEnderecoCompleto() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nrRua)
            .append(".")
            .append(this.nrPredio)
            .append(".")
            .append(this.nrApartamento);
        return sb.toString();
    }

    public boolean isOcupado() {
        return this.container != null;
    }

    public EnderecoDTO toDTO() {
        return new EnderecoDTO(this.id, this.nrRua, this.nrPredio, this.nrApartamento, this.container.toDTO());
    }

    public void atualizarDados(EnderecoDTO enderecoDTO) {
        this.nrRua = enderecoDTO.getNrRua();
        this.nrPredio = enderecoDTO.getNrPredio();
        this.nrApartamento = enderecoDTO.getNrApartamento();
    }
}