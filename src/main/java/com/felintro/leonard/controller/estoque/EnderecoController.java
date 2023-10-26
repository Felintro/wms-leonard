package com.felintro.leonard.controller.estoque;

import com.felintro.leonard.dto.estoque.EnderecoDTO;
import com.felintro.leonard.dto.estoque.ProdutoDTO;
import com.felintro.leonard.service.estoque.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author allan
 **/

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    private static final String REDIRECT_VISUALIZAR = "redirect:/endereco/visualizar";

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if(id != null) {
            var enderecoDTO = enderecoService.buscarPorId(id);
            model.addAttribute("enderecoDTO", enderecoDTO);
        }
        return "cadastro/cadastro-produto";
    }

    @PostMapping("/cadastrar")
    @Transactional
    public String cadastrarEndereco(EnderecoDTO enderecoDTO) {
        enderecoService.cadastrarEndereco(enderecoDTO);
        return REDIRECT_VISUALIZAR;
    }

    @GetMapping("/visualizar")
    public String listarEnderecos(Model model) {
        List<EnderecoDTO> listaDTO = enderecoService.listarEnderecos();
        model.addAttribute("listaDTO", listaDTO);
        return "view/view-endereco";
    }

    @PutMapping("/cadastrar")
    @Transactional
    public String alterarEndereco(EnderecoDTO enderecoDTO) {
        enderecoService.alterarEndereco(enderecoDTO);
        return REDIRECT_VISUALIZAR;
    }

    @DeleteMapping("/excluir")
    @Transactional
    public String excluirEndereco() {

        return REDIRECT_VISUALIZAR;
    }

}