package com.felintro.leonard.dto.estoque;

import com.felintro.leonard.model.estoque.ContainerProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author allan
 **/

@AllArgsConstructor
@Getter
@Setter
public class ContainerProdutoDTO {

    private Long id;
    private ContainerDTO containerDTO;
    private ProdutoDTO produtoDTO;
    private int quantidade;

    public ContainerProdutoDTO(ContainerDTO containerDTO, ProdutoDTO produtoDTO, int quantidade) {
        this.containerDTO = containerDTO;
        this.produtoDTO = produtoDTO;
        this.quantidade = quantidade;
    }

    public ContainerProduto toEntity(){
        return new ContainerProduto(produtoDTO.toEntity(), quantidade);
    }

}