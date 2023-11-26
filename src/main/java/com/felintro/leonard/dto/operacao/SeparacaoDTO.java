package com.felintro.leonard.dto.operacao;

import com.felintro.leonard.dto.estoque.ContainerDTO;
import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.enums.StatusOperacao;
import com.felintro.leonard.model.operacao.Separacao;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link Separacao}
 * @author allan
 */

@Getter
public class SeparacaoDTO implements Serializable {

    private final Long id;
    private final LocalDateTime dtHrRealizacao;
    private final StatusOperacao statusOperacao;
    private final PedidoDTO pedidoDTO;
    private final List<ContainerDTO> containerList = new ArrayList<>();

    public SeparacaoDTO(Long id, LocalDateTime dtHrRealizacao, StatusOperacao statusOperacao, PedidoDTO pedidoDTO) {
        this.id = id;
        this.dtHrRealizacao = dtHrRealizacao;
        this.statusOperacao = statusOperacao;
        this.pedidoDTO = pedidoDTO;
    }

    public void adicionarContainer(ContainerDTO containerDTO) {
        this.containerList.add(containerDTO);
    }
}