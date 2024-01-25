package com.felintro.leonard.dto.operacao;

import com.felintro.leonard.dto.estoque.EnderecoDTO;
import com.felintro.leonard.dto.estoque.PackDTO;
import com.felintro.leonard.enums.StatusOperacao;
import com.felintro.leonard.model.operacao.Armazenagem;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Armazenagem}
 * @author allan
 */
@AllArgsConstructor
@Getter
public class ArmazenagemDTO implements Serializable {

    private final Long id;
    private final LocalDateTime dtHrRealizacao;
    private final StatusOperacao statusOperacao;
    private final EnderecoDTO enderecoDestino;
    private final PackDTO pack;

    public Armazenagem toEntity() {
        return new Armazenagem(this.id, this.dtHrRealizacao, this.statusOperacao, this.enderecoDestino.toEntity(), this.pack.toEntity());
    }

}