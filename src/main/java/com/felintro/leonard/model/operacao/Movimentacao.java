package com.felintro.leonard.model.operacao;

import com.felintro.leonard.dto.operacao.MovimentacaoDTO;
import com.felintro.leonard.model.estoque.Endereco;
import com.felintro.leonard.model.estoque.Pack;
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

import java.time.LocalDate;

/**
 * @author allan
 **/

@Entity
@Table(name = "movimentacao")
@Getter
@Setter
@NoArgsConstructor
public class Movimentacao extends Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_endereco_origem", nullable = false)
    @OneToOne
    private Endereco enderecoOrigem;

    @JoinColumn(name = "id_endereco_destino", nullable = false)
    @OneToOne
    private Endereco enderecoDestino;

    @JoinColumn(name = "nr_pack", nullable = false)
    @OneToOne
    private Pack pack;

    @Column(name = "dt_realizacao", nullable = false)
    private LocalDate dtRealizacao;

    public Movimentacao(Endereco enderecoOrigem, Endereco enderecoDestino, Pack pack, LocalDate dtRealizacao) {
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.pack = pack;
        this.dtRealizacao = dtRealizacao;
    }

    public MovimentacaoDTO toDTO() {
        return new MovimentacaoDTO(this);
    }

}