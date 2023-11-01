package com.felintro.leonard.dto.pedido;

import com.felintro.leonard.dto.pessoa.EmpresaDTO;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.model.pedido.Pedido;
import com.felintro.leonard.model.pedido.PedidoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDTO {

    private Long nrPedido;
    private LocalDate dtEmissao;
    private EmpresaDTO empresaDTO;
    private List<PedidoProdutoDTO> produtosDTO = new ArrayList<>();
    private TipoPedido tipoPedido;

    public Pedido toEntity() {
        List<PedidoProduto> pedidoProdutoList = new ArrayList<>();
        produtosDTO.forEach(produtoDTO -> pedidoProdutoList.add(produtoDTO.toEntity()));
        return new Pedido(this.dtEmissao, this.empresaDTO.toEntity(), pedidoProdutoList, tipoPedido);
    }

    public PedidoDTO(Long nrPedido, LocalDate dtEmissao, EmpresaDTO empresaDTO, TipoPedido tipoPedido) {
        this.nrPedido = nrPedido;
        this.dtEmissao = dtEmissao;
        this.empresaDTO = empresaDTO;
        this.tipoPedido = tipoPedido;
    }

    public void adicionarProduto(PedidoProdutoDTO pedidoProdutoDTO) {
        pedidoProdutoDTO.setPedidoDTO(this);
        this.produtosDTO.add(pedidoProdutoDTO);
    }

}