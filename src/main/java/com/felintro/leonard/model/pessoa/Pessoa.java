package com.felintro.leonard.model.pessoa;

import com.felintro.leonard.model.autenticacao.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
public class Pessoa extends Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    @Column(name = "nr_cpf", nullable = false, unique = true, length = 11)
    private String nrCpf;

    @Column(name = "dt_nascimento", nullable = false)
    private Date dtNascimento;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nr_telefone", unique = true, nullable = false, length = 11)
    private String nrTelefone;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Usuario usuario;

}