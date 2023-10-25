package com.felintro.leonard.controller.operacao;

import com.felintro.leonard.business.operacao.MovimentacaoBusiness;
import com.felintro.leonard.dto.estoque.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author allan
 **/

@Controller
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoBusiness movimentacaoBusiness;

    @PostMapping("/efetuar")
    public String efetuarMovimentacao(Long nrContainer, EnderecoDTO enderecoDestino) {
        boolean realizouOperacao = movimentacaoBusiness.realizaMovimentacao(nrContainer, enderecoDestino.toEntity());

        if(realizouOperacao) {
            System.out.println("");
            return "";
        } else
            return "";
    }


}