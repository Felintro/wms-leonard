package com.felintro.leonard.service.estoque;

import com.felintro.leonard.dto.ProdutoDTO;
import com.felintro.leonard.model.estoque.Produto;
import com.felintro.leonard.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoDTO> retorno = new ArrayList<>();
        produtos.forEach(produto -> {
            retorno.add(produto.toDTO());
        });

        return retorno;
    }

    public void cadastrarProduto(ProdutoDTO produtoDTO) {
        var produto = produtoDTO.toEntity();
        produtoRepository.save(produto);
    }

}