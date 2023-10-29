package com.felintro.leonard.model.pedido;

import com.felintro.leonard.dto.pedido.PedidoProdutoDTO;
import com.felintro.leonard.model.estoque.Produto;
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

/**
 * @author allan
 **/

@Entity
@Table(name = "pedido_produto")
@Getter
@Setter
@NoArgsConstructor
public class PedidoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nr_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public PedidoProduto(Pedido pedido, Produto produto, int quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public PedidoProduto(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public PedidoProdutoDTO toDTO() {
        return new PedidoProdutoDTO(null, pedido.toDTO(), produto.toDTO(), this.quantidade);
    }

}