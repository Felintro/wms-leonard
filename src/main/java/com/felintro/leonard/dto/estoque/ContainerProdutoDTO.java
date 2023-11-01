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
    private ContainerDTO container;
    private ProdutoDTO produto;
    private int quantidade;

    public ContainerProdutoDTO(ContainerDTO container, ProdutoDTO produto, int quantidade) {
        this.container = container;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ContainerProduto toEntity(){
        return new ContainerProduto(produto.toEntity(), quantidade);
    }

}