package com.felintro.leonard.model.estoque;

import com.felintro.leonard.dto.estoque.ContainerDTO;
import com.felintro.leonard.dto.operacao.SepararProdutoDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "container")
@Getter
@Setter
@NoArgsConstructor
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_container")
    private Long nrContainer;

    @OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    private List<ContainerProduto> produtos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public int getQuantidadeTotal() {
        return this.produtos.stream()
            .mapToInt(ContainerProduto::getQuantidade)
            .sum();
    }

    public Container(Long nrContainer) {
        this.nrContainer = nrContainer;
    }

    public Container(SepararProdutoDTO separarProdutoDTO) {
        this.nrContainer = separarProdutoDTO.getNrContainer();
    }

    public void adicionarProduto(ContainerProduto produto) {
        produto.setContainer(this);
        this.produtos.add(produto);
    }

    public Container(List<ContainerProduto> produtos) {
        this.produtos = produtos;
    }

    public ContainerDTO toDTO() {
        ContainerDTO containerDTO = new ContainerDTO(this.nrContainer);
        if(this.endereco != null) {
            containerDTO.setEnderecoDTO(endereco.toDTO());
        }
        produtos.forEach(containerProduto -> containerDTO.adicionarProduto(containerProduto.toDTO()));
        return containerDTO;
    }

}