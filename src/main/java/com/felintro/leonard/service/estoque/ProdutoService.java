package com.felintro.leonard.service.estoque;

import com.felintro.leonard.dto.estoque.ProdutoDTO;
import com.felintro.leonard.model.estoque.Produto;
import com.felintro.leonard.repository.estoque.ProdutoRepository;
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
        produtos.forEach(produto ->  retorno.add(produto.toDTO()));
        return retorno;
    }

    public void cadastrarProduto(ProdutoDTO produtoDTO) {
        var isCadastrado = produtoRepository.existsByNrEan13AndNrDun14(produtoDTO.getNrEan13(), produtoDTO.getNrDun14());
        if(!isCadastrado) {
            var produto = produtoDTO.toEntity();
            produtoRepository.save(produto);
            System.out.println("Produto cadastrado com sucesso!");
            return;
        }
        System.out.println("O produto já existe!");
    }

}