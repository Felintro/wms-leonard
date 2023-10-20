package com.felintro.leonard.service.operacao;

import com.felintro.leonard.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author allan
 **/

@Service("movimentacaoService")
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

}