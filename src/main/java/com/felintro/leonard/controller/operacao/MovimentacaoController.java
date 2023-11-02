package com.felintro.leonard.controller.operacao;

import com.felintro.leonard.business.operacao.MovimentacaoBusiness;
import com.felintro.leonard.dto.estoque.EnderecoDTO;
import com.felintro.leonard.dto.operacao.MovimentacaoDTO;
import com.felintro.leonard.dto.operacao.RealizaMovimentacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author allan
 **/

@Controller
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    private static final String TELA_MOVIMENTACOES = "operacao/movimentacao";
    private static final String REDIRECT_FORMULARIO = "redirect:/movimentacao/formulario";

    @Autowired
    private MovimentacaoBusiness movimentacaoBusiness;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Model model) {
        List<MovimentacaoDTO> listaMovimentacaoDTOS = movimentacaoBusiness.listarMovimentacoes();
        model.addAttribute("listaMovimentacaoDTOS", listaMovimentacaoDTOS);
        model.addAttribute("nrContainer", 0);
        model.addAttribute("enderecoDestinoDTO", new EnderecoDTO());
        return TELA_MOVIMENTACOES;
    }

    @PostMapping("/efetuar")
    @Transactional
    public String efetuarMovimentacao(RealizaMovimentacaoDTO movimentacaoDTO) {
        boolean realizouOperacao = movimentacaoBusiness.realizaMovimentacao(movimentacaoDTO);
        System.out.println(realizouOperacao ? "A operação foi realizada com sucesso!" : "A operação não foi realizada!");
        return REDIRECT_FORMULARIO;
    }

}