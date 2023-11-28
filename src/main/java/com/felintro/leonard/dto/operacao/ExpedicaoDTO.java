package com.felintro.leonard.dto.operacao;

import com.felintro.leonard.dto.estoque.ContainerDTO;
import com.felintro.leonard.dto.pessoa.EmpresaDTO;
import com.felintro.leonard.enums.StatusOperacao;
import com.felintro.leonard.model.operacao.Expedicao;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link com.felintro.leonard.model.operacao.Expedicao}
 * @author allan
 */

@AllArgsConstructor
@Getter
public class ExpedicaoDTO implements Serializable {

    private final Long id;
    private final LocalDateTime dtHrRealizacao;
    private final StatusOperacao statusOperacao;
    private final EmpresaDTO empresa;
    private final List<ContainerDTO> containerList = new ArrayList<>();

    public ExpedicaoDTO(Long id, LocalDateTime dtHrRealizacao, StatusOperacao statusOperacao, EmpresaDTO empresa) {
        this.id = id;
        this.dtHrRealizacao = dtHrRealizacao;
        this.statusOperacao = statusOperacao;
        this.empresa = empresa;
    }

    public void adicionarContainer(ContainerDTO containerDTO) {
        this.containerList.add(containerDTO);
    }

    public Expedicao toEntity() {
        Expedicao expedicao = new Expedicao(this.id, this.dtHrRealizacao, this.statusOperacao, this.empresa.toEntity());
        containerList.forEach(containerDTO -> expedicao.adicionarContainer(containerDTO.toEntity()));
        return expedicao;
    }

}