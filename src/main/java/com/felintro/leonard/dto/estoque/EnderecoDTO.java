package com.felintro.leonard.dto.estoque;

import com.felintro.leonard.model.estoque.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.felintro.leonard.model.estoque.Endereco}
 * @author Allan
 */
@AllArgsConstructor
@Getter
public class EnderecoDTO implements Serializable {

    private Long id;
    private int nrRua;
    private int nrPredio;
    private int nrApartamento;

    public Endereco toEntity() {
        return new Endereco(nrRua, nrPredio, nrApartamento);
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