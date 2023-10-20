package com.felintro.leonard.model.pedido;

import com.felintro.leonard.model.estoque.ContainerProduto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author allan
 **/

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
public class Pedido {

    @Id
    @Column(name = "nr_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nrPedido;

    @Column(name = "dt_emissao", nullable = false)
    private Date dtEmissao;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoProduto> produtos = new ArrayList<>();

    @Column(name = "tipo_pedido", nullable = false)
    private char tipoPedido;

    public void adicionarProduto(PedidoProduto produto) {
        produto.setPedido(this);
        this.produtos.add(produto);
    }

}