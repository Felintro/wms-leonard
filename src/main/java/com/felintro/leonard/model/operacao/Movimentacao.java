package com.felintro.leonard.model.operacao;

import com.felintro.leonard.model.estoque.Container;
import com.felintro.leonard.model.estoque.Endereco;
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

@Entity
@Table(name = "movimentacao")
@Getter
@Setter
@NoArgsConstructor
public class Movimentacao extends Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "endereco_origem_id", nullable = false)
    @OneToOne
    private Endereco enderecoOrigem;

    @JoinColumn(name = "endereco_destino_id", nullable = false)
    @OneToOne
    private Endereco enderecoDestino;

    @JoinColumn(name = "container_id", nullable = false)
    @OneToOne
    private Container container;

}