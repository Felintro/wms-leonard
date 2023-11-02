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

import java.time.LocalDateTime;

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

    @Column(name = "dt_hr_nascimento", nullable = false)
    private LocalDateTime dtHrNascimento;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nr_telefone", unique = true, nullable = false, length = 11)
    private String nrTelefone;

    public Pessoa(String nome, String nrCpf, LocalDateTime dtHrNascimento, String email, String nrTelefone) {
        this.nome = nome;
        this.nrCpf = nrCpf;
        this.dtHrNascimento = dtHrNascimento;
        this.email = email;
        this.nrTelefone = nrTelefone;
    }

    public PessoaDTO toDTO() {
        return new PessoaDTO(this.id, this.nome, this.nrCpf, this.dtHrNascimento, this.email, this.nrTelefone);
    }

    public void atualizarDados(PessoaDTO pessoaDTO) {
        this.nome = pessoaDTO.getNome();
        this.nrCpf = pessoaDTO.getNrCpf();
        this.dtHrNascimento = pessoaDTO.getDtHrNascimento();
        this.email = pessoaDTO.getEmail();
        this.nrTelefone = pessoaDTO.getNrTelefone();
    }
}