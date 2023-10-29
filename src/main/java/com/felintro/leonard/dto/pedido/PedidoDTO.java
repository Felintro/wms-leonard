package com.felintro.leonard.dto.pedido;

import com.felintro.leonard.dto.pessoa.EmpresaDTO;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.model.pedido.Pedido;
import com.felintro.leonard.model.pedido.PedidoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@AllArgsConstructor
@Getter
@Setter
public class PedidoDTO {

    private Long nrPedido;
    private LocalDate dtEmissao;
    private EmpresaDTO empresaDTO;
    private List<PedidoProdutoDTO> produtosDTO;
    private TipoPedido tipoPedido;

    public Pedido toEntity() {
        List<PedidoProduto> pedidoProdutoList = new ArrayList<>();
        produtosDTO.forEach(produtoDTO -> pedidoProdutoList.add(produtoDTO.toEntity()));
        return new Pedido(this.dtEmissao, this.empresaDTO.toEntity(), pedidoProdutoList, tipoPedido);
    }

    public PedidoDTO(EmpresaDTO empresaDTO, List<PedidoProdutoDTO> produtosDTO, TipoPedido tipoPedido) {
        this.dtEmissao = LocalDate.now();
        this.empresaDTO = empresaDTO;
        this.produtosDTO = produtosDTO;
        this.tipoPedido = tipoPedido;
    }

    public void adicionarProduto(PedidoProdutoDTO pedidoProdutoDTO) {
        pedidoProdutoDTO.setPedidoDTO(this);
        this.produtosDTO.add(pedidoProdutoDTO);
    }

}