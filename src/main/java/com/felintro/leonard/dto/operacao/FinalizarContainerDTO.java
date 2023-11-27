package com.felintro.leonard.dto.operacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO finalizar container em um endereço
 * @author allan
 **/

@Getter
@AllArgsConstructor
public class FinalizarContainerDTO {

    private Long nrPedidoSeparacao;
    private Long nrContainerFinalizar;
    private int nrRuaFinalizar;
    private int nrPredioFinalizar;
    private int nrApartamentoFinalizar;

}