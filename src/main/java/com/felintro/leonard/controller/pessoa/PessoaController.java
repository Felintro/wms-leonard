package com.felintro.leonard.controller.pessoa;

import com.felintro.leonard.dto.pessoa.PessoaDTO;
import com.felintro.leonard.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author allan
 **/

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    private static final String REDIRECT_VISUALIZAR = "redirect:/pessoa/visualizar";

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if(id != null) {
            var pessoaDTO = pessoaService.buscarPorId(id);
            model.addAttribute("pessoaDTO", pessoaDTO);
        }
        return "cadastro/cadastro-pessoa";
    }

    @PostMapping("/cadastrar")
    @Transactional
    public String cadastrarPessoa(PessoaDTO pessoaDTO) {
        pessoaService.cadastrarPessoa(pessoaDTO);
        return REDIRECT_VISUALIZAR;
    }

    @GetMapping("/visualizar")
    public String listarPessoas(Model model) {
        List<PessoaDTO> listaDTO = pessoaService.listarPessoas();
        model.addAttribute("listaDTO", listaDTO);
        return "view/view-pessoa";
    }

    @PutMapping("/cadastrar")
    @Transactional
    public String alterarPessoa(PessoaDTO pessoaDTO) {
        pessoaService.alterarPessoa(pessoaDTO);
        return REDIRECT_VISUALIZAR;
    }

}