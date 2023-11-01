package com.felintro.leonard.model.pessoa;

import com.felintro.leonard.dto.pessoa.EmpresaDTO;
import com.felintro.leonard.enums.TipoEmpresa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Column(name = "nr_cnpj", nullable = false, unique = true, length = 14)
    private String nrCnpj;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nr_telefone", unique = true, nullable = false, length = 11)
    private String nrTelefone;

    @Column(name = "tipo_empresa")
    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;


    public Empresa(String razaoSocial, String nrCnpj, String email, String nrTelefone, TipoEmpresa tipoEmpresa) {
        this.razaoSocial = razaoSocial;
        this.nrCnpj = nrCnpj;
        this.email = email;
        this.nrTelefone = nrTelefone;
        this.tipoEmpresa = tipoEmpresa;
    }

    public EmpresaDTO toDTO() {
        return new EmpresaDTO(this.id, this.razaoSocial, this.nrCnpj, this.tipoEmpresa, this.email, this.nrTelefone);
    }

    public void atualizarDados(EmpresaDTO empresaDTO) {
        this.razaoSocial = empresaDTO.getRazaoSocial();
        this.nrCnpj = empresaDTO.getNrCnpj();
        this.email = empresaDTO.getEmail();
        this.nrTelefone = empresaDTO.getNrTelefone();
        this.tipoEmpresa = empresaDTO.getTipoEmpresa();
    }
}