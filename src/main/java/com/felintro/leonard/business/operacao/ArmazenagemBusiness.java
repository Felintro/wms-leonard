package com.felintro.leonard.business.operacao;

import com.felintro.leonard.dto.operacao.ArmazenagemDTO;
import com.felintro.leonard.dto.operacao.RealizaMovimentacaoDTO;
import com.felintro.leonard.model.operacao.Armazenagem;
import com.felintro.leonard.repository.estoque.EnderecoRepository;
import com.felintro.leonard.repository.estoque.PackRepository;
import com.felintro.leonard.repository.operacao.ArmazenagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@Service
public class ArmazenagemBusiness {

    @Autowired
    private ArmazenagemRepository armazenagemRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PackRepository packRepository;

    public List<ArmazenagemDTO> listarMovimentacoes() {
        List<Armazenagem> armazenagemList = armazenagemRepository.findAll();
        List<ArmazenagemDTO> retorno = new ArrayList<>();
        armazenagemList.forEach(armazenagem ->  retorno.add(armazenagem.toDTO()));
        return retorno;
    }

    public boolean realizaArmazenagem(RealizaMovimentacaoDTO realizaMovimentacaoDTO) {

    }

}