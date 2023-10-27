package com.felintro.leonard.dto.estoque;

import com.felintro.leonard.model.estoque.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link com.felintro.leonard.model.estoque.Produto}
 */

@AllArgsConstructor
@Getter
public class ProdutoDTO implements Serializable {

    private final Long id;
    private final String descricao;
    private final String nrEan13;
    private final String nrDun14;
    private final int fatorCaixa;

    public Produto toEntity() {
        return new Produto(descricao, nrEan13, nrDun14, fatorCaixa);
    }

}