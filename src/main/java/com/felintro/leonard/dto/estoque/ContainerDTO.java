package com.felintro.leonard.dto.estoque;

import com.felintro.leonard.model.estoque.Container;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@Getter
public class ContainerDTO implements Serializable {

    private Long nrContainer;
    private List<ContainerProdutoDTO> containerProdutosDTO = new ArrayList<>();
    private EnderecoDTO enderecoDTO;

    public ContainerDTO(Long nrContainer) {
        this.nrContainer = nrContainer;
    }

    public void adicionarProduto(ContainerProdutoDTO containerProdutoDTO) {
        containerProdutoDTO.setContainer(this);
        this.containerProdutosDTO.add(containerProdutoDTO);
    }

    public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }

    public Container toEntity() {
        Container container = new Container(this.nrContainer);
        containerProdutosDTO.forEach(containerProdutoDTO -> container.adicionarProduto(containerProdutoDTO.toEntity()));
        return container;
    }

}