package com.felintro.leonard.dto.operacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO para receber produtos
 * @author allan
 **/

@Getter
@AllArgsConstructor
public class ReceberProdutoDTO {

    private Long nrPedido;
    private Long nrPack;
    private String nrEan13;
    private int qtdeRecebida;

}