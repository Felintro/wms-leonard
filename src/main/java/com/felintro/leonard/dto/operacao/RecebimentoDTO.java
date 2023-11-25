package com.felintro.leonard.dto.operacao;

import com.felintro.leonard.dto.estoque.PackDTO;
import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.enums.StatusOperacao;
import com.felintro.leonard.model.estoque.Pack;
import com.felintro.leonard.model.operacao.Recebimento;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link com.felintro.leonard.model.operacao.Recebimento}
 * @author allan
 */
@AllArgsConstructor
@Getter
public class RecebimentoDTO implements Serializable {

    private final Long id;
    private final LocalDateTime dtHrRealizacao;
    private final StatusOperacao statusOperacao;
    private final PedidoDTO pedidoDTO;
    private final List<PackDTO> packListDTO;

    public Recebimento toEntity() {
        List<Pack> packList = new ArrayList<>();
        packListDTO.forEach(packDTO -> packList.add(packDTO.toEntity()));
        return new Recebimento(this.id, this.dtHrRealizacao, this.statusOperacao, this.pedidoDTO.toEntity(), packList);
    }

}