package com.felintro.leonard.dto.estoque;

import com.felintro.leonard.model.estoque.Container;
import com.felintro.leonard.model.estoque.ContainerProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@AllArgsConstructor
@Getter
@Setter
public class ContainerDTO {

    private Long nrContainer;
    private List<ContainerProdutoDTO> containerProdutosDTO;

    public void adicionarProduto(ContainerProdutoDTO containerProdutoDTO) {
        containerProdutoDTO.setContainer(this);
        this.containerProdutosDTO.add(containerProdutoDTO);
    }

    public Container toEntity() {
        List<ContainerProduto> containerProdutoList = new ArrayList<>();
        containerProdutosDTO.forEach(produtoDTO -> containerProdutoList.add(produtoDTO.toEntity()));
        return new Container(containerProdutoList);
    }

}