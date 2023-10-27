package com.felintro.leonard.dto.pedido;

import com.felintro.leonard.dto.estoque.ProdutoDTO;
import com.felintro.leonard.model.pedido.PedidoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author allan
 **/

@AllArgsConstructor
@Getter
@Setter
public class PedidoProdutoDTO {

    private Long id;
    private PedidoDTO pedidoDTO;
    private ProdutoDTO produtoDTO;
    private int quantidade;

    public PedidoProduto toEntity(){
        return new PedidoProduto(this.pedidoDTO.toEntity(), this.produtoDTO.toEntity(), quantidade);
    }

}