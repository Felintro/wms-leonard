package com.felintro.leonard.controller.cadastro;

import com.felintro.leonard.dto.EnderecoDTO;
import com.felintro.leonard.service.estoque.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author allan
 **/

@Controller
@RequestMapping("/endereco")
public class CadastroEnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/formulario")
    public String abrirFormularioCadastro() {
        return "cadastro/cadastro-endereco";
    }

    @PostMapping("/cadastrar")
    public String cadastrarEndereco(EnderecoDTO enderecoDTO) {
        enderecoService.cadastrarEndereco(enderecoDTO);
        return "redirect:/endereco/visualizar";
    }

    @GetMapping("/visualizar")
    public String listarEnderecos(Model model) {
        List<EnderecoDTO> listaDTO = enderecoService.listarEnderecos();
        model.addAttribute("listaDTO", listaDTO);
        return "view/view-endereco";
    }

}