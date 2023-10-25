package com.felintro.leonard.model.pessoa;

import com.felintro.leonard.dto.pessoa.PessoaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    @Column(name = "nr_cpf", nullable = false, unique = true, length = 11)
    private String nrCpf;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dtNascimento;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nr_telefone", unique = true, nullable = false, length = 11)
    private String nrTelefone;

    public Pessoa(String nome, String nrCpf, LocalDate dtNascimento, String email, String nrTelefone) {
        this.nome = nome;
        this.nrCpf = nrCpf;
        this.dtNascimento = dtNascimento;
        this.email = email;
        this.nrTelefone = nrTelefone;
    }

    public PessoaDTO toDTO() {
        return new PessoaDTO(this.id, this.nome, this.nrCpf, this.dtNascimento, this.email, this.nrTelefone);
    }
}