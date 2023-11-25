package com.felintro.leonard.model.operacao;

import com.felintro.leonard.dto.estoque.PackDTO;
import com.felintro.leonard.dto.operacao.RecebimentoDTO;
import com.felintro.leonard.enums.StatusOperacao;
import com.felintro.leonard.model.estoque.Pack;
import com.felintro.leonard.model.pedido.Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recebimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recebimento extends Operacao {

    @OneToOne
    @JoinColumn(name = "nr_pedido", nullable = false)
    private Pedido pedido;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recebimento_pack",
        joinColumns = {@JoinColumn(name = "id_recebimento")},
        inverseJoinColumns = {@JoinColumn(name = "nr_pack")})
    private List<Pack> packList = new ArrayList<>();

    public Recebimento(Long id, LocalDateTime dtHrRealizacao, StatusOperacao statusOperacao, Pedido pedido, List<Pack> packList) {
        super(id, dtHrRealizacao, statusOperacao);
        this.pedido = pedido;
        this.packList = packList;
    }

    public RecebimentoDTO toDTO() {
        List<PackDTO> packListDTO = new ArrayList<>();
        packList.forEach(pack -> packListDTO.add(pack.toDTO()));
        return new RecebimentoDTO(this.id, this.dtHrRealizacao, this.statusOperacao, this.pedido.toDTO(), packListDTO);
    }

}