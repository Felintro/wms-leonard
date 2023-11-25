package com.felintro.leonard.dto.operacao;

import com.felintro.leonard.model.operacao.Movimentacao;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link Movimentacao}
 */
@AllArgsConstructor
@Getter
public class RealizaMovimentacaoDTO implements Serializable {

    private int nrRuaDestino;
    private int nrPredioDestino;
    private int nrApartamentoDestino;
    private Long nrPack;

}