package com.felintro.leonard.model.estoque;

import com.felintro.leonard.dto.estoque.ContainerProdutoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "container_produto")
@Getter
@Setter
@NoArgsConstructor
public class ContainerProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nr_container")
    private Container container;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public ContainerProduto(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ContainerProdutoDTO toDTO() {
        return new ContainerProdutoDTO(this.id, this.produto.toDTO(), this.quantidade);
    }

}