package com.felintro.leonard.model.pessoa;

import com.felintro.leonard.dto.pessoa.EmpresaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nr_telefone", unique = true, nullable = false, length = 11)
    private String nrTelefone;

    @Column(name = "nr_cnpj", nullable = false, unique = true)
    private String nrCnpj;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "status")
    private boolean status;

    public Empresa(String email, String nrTelefone, String nrCnpj, String razaoSocial) {
        this.email = email;
        this.nrTelefone = nrTelefone;
        this.nrCnpj = nrCnpj;
        this.razaoSocial = razaoSocial;
        this.status = true;
    }

    public boolean isAtivo() {
        return this.status;
    }

    public EmpresaDTO toDTO() {
        return new EmpresaDTO(this.email, this.nrTelefone, this.nrCnpj, this.razaoSocial, this.status);
    }

}