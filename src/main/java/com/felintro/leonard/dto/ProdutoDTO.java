package com.felintro.leonard.dto;

import com.felintro.leonard.model.estoque.Produto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link com.felintro.leonard.model.estoque.Produto}
 */

@AllArgsConstructor
@Getter
@Setter
public class ProdutoDTO implements Serializable {

    private final String descricao;
    private final String nrEan13;
    private final String nrDun14;
    private final int fatorCaixa;

    public Produto toEntity() {
        return new Produto(descricao, nrEan13, nrDun14, fatorCaixa);
    }

}