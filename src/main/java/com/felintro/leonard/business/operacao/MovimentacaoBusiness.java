package com.felintro.leonard.business.operacao;

import com.felintro.leonard.model.estoque.Endereco;
import com.felintro.leonard.repository.estoque.ContainerRepository;
import com.felintro.leonard.repository.estoque.EnderecoRepository;
import com.felintro.leonard.repository.operacao.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author allan
 **/

@Service
public class MovimentacaoBusiness {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContainerRepository containerRepository;

    public boolean realizaMovimentacao(Long nrContainer, Endereco enderecoDestino) {
        return true;
    }

}