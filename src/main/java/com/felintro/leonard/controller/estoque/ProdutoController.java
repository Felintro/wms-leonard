package com.felintro.leonard.controller.estoque;

import com.felintro.leonard.dto.estoque.ProdutoDTO;
import com.felintro.leonard.service.estoque.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoController {

    private static final String TELA_CADASTRO = "cadastro/cadastro-produto";
    private static final String REDIRECT_FORMULARIO = "redirect:/produto/formulario";

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if(id != null) {
            var produtoDTO = produtoService.buscarPorId(id);
            model.addAttribute("produtoDTO", produtoDTO);
        }
        List<ProdutoDTO> listaDTO = produtoService.listarProdutos();
        model.addAttribute("listaDTO", listaDTO);
        return TELA_CADASTRO;
    }

    @PostMapping("/cadastrar")
    @Transactional
    public String cadastrarProduto(ProdutoDTO produtoDTO) {
        produtoService.cadastrarProduto(produtoDTO);
        return REDIRECT_FORMULARIO;
    }

    @PutMapping("/cadastrar")
    @Transactional
    public String alterarProduto(ProdutoDTO produtoDTO) {
        produtoService.alterarProduto(produtoDTO);
        return REDIRECT_FORMULARIO;
    }

    /*@GetMapping("/visualizar")
    public String listarProdutos(Model model) {
        List<ProdutoDTO> listaDTO = produtoService.listarProdutos();
        model.addAttribute("listaDTO", listaDTO);
        return "view/view-produto";
    }*/

}