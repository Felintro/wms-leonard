package com.felintro.leonard.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author allan
 **/

@AllArgsConstructor
@Getter
public class RegistraProdutoPedidoDTO {
    private String nrEan13;
    private int qtde;
}