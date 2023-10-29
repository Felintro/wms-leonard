package com.felintro.leonard.dto.pedido;

import com.felintro.leonard.enums.TipoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author allan
 **/

@AllArgsConstructor
@Getter
public class RegistraPedidoDTO {

    private String nrCnpj;
    private List<RegistraProdutoPedidoDTO> produtos;
    private TipoPedido tipoPedido;

}