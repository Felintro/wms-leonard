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

    public ContainerProduto toEntity(){
        return new ContainerProduto(container.toEntity(), produto.toEntity(), quantidade);
    }

}