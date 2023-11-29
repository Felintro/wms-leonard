package com.felintro.leonard.business.operacao;

import com.felintro.leonard.repository.estoque.ContainerRepository;
import com.felintro.leonard.repository.operacao.ExpedicaoRepository;
import com.felintro.leonard.repository.operacao.SeparacaoRepository;
import com.felintro.leonard.repository.pessoa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author allan
 **/

@Service
public class ExpedicaoBusiness {

    @Autowired
    private ExpedicaoRepository expedicaoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    private SeparacaoRepository separacaoRepository;

}