package com.felintro.leonard.dto;

import com.felintro.leonard.model.estoque.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * DTO for {@link com.felintro.leonard.model.estoque.Endereco}
 */
@AllArgsConstructor
@Getter
public class EnderecoDTO implements Serializable {

    private final int numeroRua;
    private final int numeroPredio;
    private final int numeroApartamento;

    public Endereco toEntity() {
        return new Endereco(numeroRua, numeroPredio, numeroApartamento);
    }

}