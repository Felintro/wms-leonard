package com.felintro.leonard.controller.operacao;

import com.felintro.leonard.business.operacao.ArmazenagemBusiness;
import com.felintro.leonard.dto.operacao.ArmazenagemDTO;
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
@RequestMapping("/armazenagem")
public class ArmazenagemController {

    private static final String TELA_ARMAZENAGEM = "operacao/armazenagem";
    private static final String REDIRECT_FORMULARIO = "redirect:/armazenagem/formulario";

    @Autowired
    private ArmazenagemBusiness armazenagemBusiness;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Model model) {
        List<ArmazenagemDTO> listaArmazenagemDTO = armazenagemBusiness.listarMovimentacoes();
        model.addAttribute("listaArmazenagemDTO", listaArmazenagemDTO);
        return TELA_ARMAZENAGEM;
    }

    @PostMapping("/efetuar")
    @Transactional
    public String efetuarArmazenagem(RealizaMovimentacaoDTO realizaMovimentacaoDTO) {
        boolean realizouOperacao = armazenagemBusiness.realizaArmazenagem(realizaMovimentacaoDTO);
        System.out.println(realizouOperacao ? "A operação foi realizada com sucesso!" : "A operação não foi realizada!");
        return REDIRECT_FORMULARIO;
    }

}