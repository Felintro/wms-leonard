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
    @JoinColumn(name = "nr_pack")
    private Pack pack;

    public Endereco(int numeroRua, int nrPredio, int numeroApartamento) {
        this.nrRua = numeroRua;
        this.nrPredio = nrPredio;
        this.nrApartamento = numeroApartamento;
    }

    public String getEnderecoCompleto() {
        return this.toDTO().getEnderecoCompleto();
    }

    public boolean isOcupado() {
        return this.pack != null;
    }

    public EnderecoDTO toDTO() {
        return new EnderecoDTO(this.id, this.nrRua, this.nrPredio, this.nrApartamento);
    }

    public void atualizarDados(EnderecoDTO enderecoDTO) {
        this.nrRua = enderecoDTO.getNrRua();
        this.nrPredio = enderecoDTO.getNrPredio();
        this.nrApartamento = enderecoDTO.getNrApartamento();
    }
}