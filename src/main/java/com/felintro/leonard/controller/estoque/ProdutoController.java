package com.felintro.leonard.controller.estoque;

import com.felintro.leonard.dto.estoque.ProdutoDTO;
import com.felintro.leonard.service.estoque.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/formulario")
    public String abrirFormularioCadastro() {
        return "cadastro/cadastro-produto";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(ProdutoDTO produtoDTO) {
        produtoService.cadastrarProduto(produtoDTO);
        return "redirect:/produto/visualizar";
    }

    @GetMapping("/visualizar")
    public String listarProdutos(Model model) {
        List<ProdutoDTO> listaDTO = produtoService.listarProdutos();
        model.addAttribute("listaDTO", listaDTO);
        return "view/view-produto";
    }

}