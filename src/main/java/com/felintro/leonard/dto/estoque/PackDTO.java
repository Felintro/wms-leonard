package com.felintro.leonard.dto.estoque;

import com.felintro.leonard.model.estoque.Pack;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author allan
 **/

@AllArgsConstructor
@Getter
public class PackDTO {

    private Long nrPack;
    private ProdutoDTO produtoDTO;
    private int quantidade;

    public Pack toEntity() {
        return new Pack(this.nrPack, this.produtoDTO.toEntity(), this.quantidade);
    }

}