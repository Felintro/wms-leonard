package com.felintro.leonard.business.operacao;

import com.felintro.leonard.model.operacao.Movimentacao;
import com.felintro.leonard.repository.operacao.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author allan
 **/

@Service
public class MovimentacaoBusiness {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

}