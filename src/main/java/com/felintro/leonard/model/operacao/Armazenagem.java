package com.felintro.leonard.model.operacao;

import com.felintro.leonard.dto.operacao.ArmazenagemDTO;
import com.felintro.leonard.enums.StatusOperacao;
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
@Table(name = "armazenagem")
@Getter
@Setter
@NoArgsConstructor
public class Armazenagem extends Operacao {

    @OneToOne
    @JoinColumn(name = "id_endereco_destino", nullable = false)
    private Endereco enderecoDestino;

    @OneToOne
    @JoinColumn(name = "nr_pack", nullable = false)
    private Pack pack;

    public Armazenagem(Endereco enderecoDestino, Pack pack, LocalDateTime dtHrRealizacao) {
        this.dtHrRealizacao = dtHrRealizacao;
        this.enderecoDestino = enderecoDestino;
        this.pack = pack;
    }

    public Armazenagem(Long id, LocalDateTime dtHrRealizacao, StatusOperacao statusOperacao, Endereco enderecoDestino, Pack pack) {
        super(id, dtHrRealizacao, statusOperacao);
        this.enderecoDestino = enderecoDestino;
        this.pack = pack;
    }

    public ArmazenagemDTO toDTO() {
        return new ArmazenagemDTO(this.id, this.dtHrRealizacao, this.statusOperacao, this.enderecoDestino.toDTO(), this.pack.toDTO());
    }

}