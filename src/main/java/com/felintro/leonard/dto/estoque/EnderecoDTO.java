package com.felintro.leonard.dto.estoque;

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

    private final Long id;
    private final int nrRua;
    private final int nrPredio;
    private final int nrApartamento;
    private final ContainerDTO containerDTO;

    public Endereco toEntity() {
        return new Endereco(nrRua, nrPredio, nrApartamento, containerDTO.toEntity());
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
}