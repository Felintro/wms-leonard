package com.felintro.leonard.model.operacao;

import com.felintro.leonard.model.estoque.Container;
import com.felintro.leonard.model.pedido.Pedido;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "separacao")
@Getter
@Setter
@NoArgsConstructor
public class Separacao extends Operacao {

    @OneToOne
    @JoinColumn(name = "nr_pedido", nullable = false)
    private Pedido pedido;

    @OneToMany
    @JoinTable(name = "separacao_container")
    private List<Container> containerList = new ArrayList<>();

}