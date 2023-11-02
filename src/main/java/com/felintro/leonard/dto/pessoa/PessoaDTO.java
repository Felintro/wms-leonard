package com.felintro.leonard.dto.pessoa;

import com.felintro.leonard.model.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.felintro.leonard.model.pessoa.Pessoa}
 */
@AllArgsConstructor
@Getter
public class PessoaDTO implements Serializable {

    private final Long id;
    private final String nome;
    private final String nrCpf;
    private final LocalDateTime dtHrNascimento;
    private final String email;
    private final String nrTelefone;

    public Pessoa toEntity() {
        return new Pessoa(this.nome, this.nrCpf, this.dtHrNascimento, this.email, this.nrTelefone);
    }
}