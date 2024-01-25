package com.felintro.leonard.model.operacao;

import com.felintro.leonard.dto.operacao.ExpedicaoDTO;
import com.felintro.leonard.dto.operacao.SeparacaoDTO;
import com.felintro.leonard.enums.StatusOperacao;
import com.felintro.leonard.model.estoque.Container;
import com.felintro.leonard.model.pessoa.Empresa;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "expedicao")
@Getter
@Setter
@NoArgsConstructor
public class Expedicao extends Operacao {

    @OneToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany
    @JoinTable(name = "expedicao_container",
        joinColumns = {@JoinColumn(name = "id_expedicao")},
        inverseJoinColumns = {@JoinColumn(name = "nr_container")})
    private List<Container> containerList;

    public void adicionarContainer(Container container) {
        this.containerList.add(container);
    }

    public Expedicao(Long id, LocalDateTime dtHrRealizacao, StatusOperacao statusOperacao, Empresa empresa) {
        super(id, dtHrRealizacao, statusOperacao);
        this.empresa = empresa;
    }

    public ExpedicaoDTO toDTO() {
        ExpedicaoDTO expedicaoDTO = new ExpedicaoDTO(this.id, this.dtHrRealizacao, this.statusOperacao, this.empresa.toDTO());
        this.containerList.forEach(container -> expedicaoDTO.adicionarContainer(container.toDTO()));
        return expedicaoDTO;
    }
}