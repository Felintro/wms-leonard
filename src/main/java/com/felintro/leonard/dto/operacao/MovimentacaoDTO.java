package com.felintro.leonard.dto.operacao;

import com.felintro.leonard.dto.estoque.EnderecoDTO;
import com.felintro.leonard.dto.estoque.PackDTO;
import com.felintro.leonard.model.operacao.Movimentacao;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.felintro.leonard.model.operacao.Movimentacao}
 *
 * @author allan
 *
 */
@AllArgsConstructor
@Getter
public class MovimentacaoDTO implements Serializable {

    private final Long id;
    private final EnderecoDTO enderecoOrigem;
    private final EnderecoDTO enderecoDestino;
    private final PackDTO pack;
    private final LocalDateTime dtHrRealizacao;

    public MovimentacaoDTO(Movimentacao movimentacao) {
        this.id = movimentacao.getId();
        this.enderecoOrigem = movimentacao.getEnderecoOrigem().toDTO();
        this.enderecoDestino = movimentacao.getEnderecoDestino().toDTO();
        this.pack = movimentacao.getPack().toDTO();
        this.dtHrRealizacao = movimentacao.getDtHrRealizacao();
    }
}