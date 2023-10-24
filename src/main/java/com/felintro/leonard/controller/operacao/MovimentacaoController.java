package com.felintro.leonard.controller.operacao;

import com.felintro.leonard.service.operacao.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author allan
 **/

@Controller
@RequestMapping("/operacao/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

}