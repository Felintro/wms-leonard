package com.felintro.leonard.model.pedido;

import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.model.pessoa.Empresa;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate dtEmissao;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoProduto> produtos = new ArrayList<>();

    @JoinColumn(name = "id_empresa", nullable = false)
    @OneToOne
    private Empresa empresa;

    @Column(name = "tipo_pedido")
    @Enumerated(EnumType.STRING)
    private TipoPedido tipoPedido;

    @Column(name = "status_pedido")
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    public Pedido(LocalDate dtEmissao, Empresa empresa, List<PedidoProduto> produtos, TipoPedido tipoPedido) {
        this.dtEmissao = dtEmissao;
        this.empresa = empresa;
        this.produtos = produtos;
        this.tipoPedido = tipoPedido;
    }

    public void adicionarProduto(PedidoProduto produto) {
        produto.setPedido(this);
        this.produtos.add(produto);
    }

    public Pedido(Empresa empresa, TipoPedido tipoPedido) {
        this.empresa = empresa;
        this.tipoPedido = tipoPedido;
    }

    public PedidoDTO toDTO() {
        PedidoDTO pedidoDTO = new PedidoDTO(this.nrPedido, this.dtEmissao, this.empresa.toDTO(), this.tipoPedido);
        this.produtos.forEach(produto -> pedidoDTO.adicionarProduto(produto.toDTO()));
        return pedidoDTO;
    }
}