package com.felintro.leonard.service.estoque;

import com.felintro.leonard.dto.estoque.EnderecoDTO;
import com.felintro.leonard.model.estoque.Endereco;
import com.felintro.leonard.repository.estoque.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void cadastrarEndereco(EnderecoDTO enderecoDTO) {
        var IsCadastrado = enderecoRepository.existsByNrRuaAndNrPredioAndNrApartamento(enderecoDTO.getNrRua(), enderecoDTO.getNrPredio(), enderecoDTO.getNrApartamento());
        if(!IsCadastrado) {
            var endereco = enderecoDTO.toEntity();
            enderecoRepository.save(endereco);
            System.out.println("O endereço foi cadastrado com sucesso:");
            return;
        }
        System.out.println("O endereço já existe!");
    }

    public List<EnderecoDTO> listarEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        List<EnderecoDTO> retorno = new ArrayList<>();
        enderecos.forEach(endereco -> retorno.add(endereco.toDTO()));
        return retorno;
    }

    public EnderecoDTO buscarPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id).get();
        return endereco.toDTO();
    }

    public void cadastraVariosEnderecos(int qtdeRuas, int qtdePredios, int qtdeApartamentos) {
        List<EnderecoDTO> listaEnderecos = new ArrayList<>();

        for(int i=1; i<=qtdeRuas; i++) {
            for(int j=1; j<=qtdePredios; j++) {
                for(int k=1; k<=qtdeApartamentos; k++) {
                    listaEnderecos.add(new EnderecoDTO(i, j, k));
                }
            }
        }

        listaEnderecos.forEach(enderecoDTO -> cadastrarEndereco(enderecoDTO));
    }

}