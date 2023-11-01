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

@Getter
@Setter
public class ContainerDTO {

    private Long nrContainer;
    private List<ContainerProdutoDTO> containerProdutosDTO = new ArrayList<>();

    public ContainerDTO(Long nrContainer) {
        this.nrContainer = nrContainer;
    }

    public void adicionarProduto(ContainerProdutoDTO containerProdutoDTO) {
        containerProdutoDTO.setContainer(this);
        this.containerProdutosDTO.add(containerProdutoDTO);
    }

    public Container toEntity() {
        Container container = new Container(this.nrContainer);
        containerProdutosDTO.forEach(containerProdutoDTO -> container.adicionarProduto(containerProdutoDTO.toEntity()));
        return container;
    }

}