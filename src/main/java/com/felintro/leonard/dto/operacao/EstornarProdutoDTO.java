package com.felintro.leonard.dto.operacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO para estornar produtos de uma operação de recebimento
 * @author allan
 **/

@AllArgsConstructor
@Getter
public class EstornarProdutoDTO {

    private Long nrPackEstorno;
    private Long nrPedidoEstorno;

}