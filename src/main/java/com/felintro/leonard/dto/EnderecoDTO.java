package com.felintro.leonard.dto;

import com.felintro.leonard.model.estoque.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link com.felintro.leonard.model.estoque.Endereco}
 */
@AllArgsConstructor
@Getter
public class EnderecoDTO implements Serializable {

    private final int nrRua;
    private final int nrPredio;
    private final int nrApartamento;

    public Endereco toEntity() {
        return new Endereco(nrRua, nrPredio, nrApartamento);
    }

}