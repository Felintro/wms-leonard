package com.felintro.leonard.dto.operacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO para separar produtos
 * @author allan
 **/

@Getter
@AllArgsConstructor
public class SepararProdutoDTO {

    private Long nrPedido;
    private Long nrContainer;
    private String nrEan13;
    private int qtdeSeparada;

}