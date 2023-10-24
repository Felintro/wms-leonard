package com.felintro.leonard.dto.pessoa;

import com.felintro.leonard.model.pessoa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link com.felintro.leonard.model.pessoa.Empresa}
 */
@AllArgsConstructor
@Getter
public class EmpresaDTO implements Serializable {

    private final String email;
    private final String nrTelefone;
    private final String nrCnpj;
    private final String razaoSocial;
    private final boolean status;

    public Empresa toEntity() {
        return new Empresa(email, nrTelefone, nrCnpj, razaoSocial);
    }

}