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

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "nr_cnpj", nullable = false, unique = true)
    private String nrCnpj;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nr_telefone", unique = true, nullable = false, length = 11)
    private String nrTelefone;

    @Column(name = "status")
    private boolean status;

    public Empresa(String razaoSocial, String nrCnpj, String email, String nrTelefone, boolean status) {
        this.razaoSocial = razaoSocial;
        this.nrCnpj = nrCnpj;
        this.email = email;
        this.nrTelefone = nrTelefone;
        this.status = status;
    }

    public boolean isAtivo() {
        return this.status;
    }

    public EmpresaDTO toDTO() {
        return new EmpresaDTO(this.id, this.email, this.nrTelefone, this.nrCnpj, this.razaoSocial, this.status);
    }

    public void atualizarDados(EmpresaDTO empresaDTO) {
        this.razaoSocial = empresaDTO.getRazaoSocial();
        this.nrCnpj = empresaDTO.getNrCnpj();
        this.email = empresaDTO.getEmail();
        this.nrTelefone = empresaDTO.getNrTelefone();
        this.status = empresaDTO.isStatus();

    }
}