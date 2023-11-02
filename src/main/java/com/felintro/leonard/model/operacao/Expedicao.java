package com.felintro.leonard.model.operacao;

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
    @JoinTable(name = "expedicao_container")
    private List<Container> containerList;

    public void adicionarContainer(Container container) {
        this.containerList.add(container);
    }

}