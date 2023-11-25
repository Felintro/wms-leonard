package com.felintro.leonard.model.operacao;

import com.felintro.leonard.dto.operacao.MovimentacaoDTO;
import com.felintro.leonard.model.estoque.Endereco;
import com.felintro.leonard.model.estoque.Pack;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author allan
 **/

@Entity
@Table(name = "movimentacao")
@Getter
@Setter
@NoArgsConstructor
public class Movimentacao extends Operacao {

    @JoinColumn(name = "id_endereco_origem")
    @OneToOne
    private Endereco enderecoOrigem;

    @JoinColumn(name = "id_endereco_destino", nullable = false)
    @OneToOne
    private Endereco enderecoDestino;

    @JoinColumn(name = "nr_pack", nullable = false)
    @OneToOne
    private Pack pack;

    public Movimentacao(Endereco enderecoOrigem, Endereco enderecoDestino, Pack pack, LocalDateTime dtHrRealizacao) {
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.pack = pack;
        this.dtHrRealizacao = dtHrRealizacao;
    }

    public MovimentacaoDTO toDTO() {
        return new MovimentacaoDTO(this);
    }

}