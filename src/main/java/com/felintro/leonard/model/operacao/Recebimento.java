package com.felintro.leonard.model.operacao;

import com.felintro.leonard.model.estoque.Pack;
import com.felintro.leonard.model.pedido.Pedido;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "recebimento")
public class Recebimento extends Operacao {

    @OneToOne
    @JoinColumn(name = "nr_pedido", nullable = false)
    private Pedido pedido;

    @OneToMany
    @JoinTable(name = "recebimento_pack",
        joinColumns = {@JoinColumn(name = "id_recebimento")},
        inverseJoinColumns = {@JoinColumn(name = "nr_pack")})
    private List<Pack> packList;

}