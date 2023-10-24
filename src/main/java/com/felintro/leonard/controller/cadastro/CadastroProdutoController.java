package com.felintro.leonard.controller.cadastro;

import com.felintro.leonard.dto.ProdutoDTO;
import com.felintro.leonard.model.estoque.Produto;
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
@RequestMapping("/cadastro/produto")
public class CadastroProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/formulario")
    public String abrirFormularioCadastro() {
        return "cadastro/cadastro-produto";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(ProdutoDTO produtoDTO) {
        var produto = new Produto(produtoDTO);
        produtoService.cadastrarProduto(produto);
        System.out.println(produto.toString());
        return "view/view-produtos";
    }

    @GetMapping("/visualizar")
    public String listarProdutos(Model model) {
        List<ProdutoDTO> listaDTO = produtoService.listarProdutos();
        model.addAttribute("listaDTO", listaDTO);
        return "view/view-produtos";
    }

}