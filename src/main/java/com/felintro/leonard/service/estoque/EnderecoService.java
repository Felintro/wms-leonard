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
        var isCadastrado = enderecoRepository.existsByNrRuaAndNrPredioAndNrApartamento(enderecoDTO.getNrRua(), enderecoDTO.getNrPredio(), enderecoDTO.getNrApartamento());
        if(!isCadastrado) {
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
        List<EnderecoDTO> listaEnderecos = gerarEnderecosDTOEmLote(qtdeRuas, qtdePredios, qtdeApartamentos);
        listaEnderecos.forEach(enderecoDTO -> cadastrarEndereco(enderecoDTO));
    }

    public void alterarEndereco(EnderecoDTO enderecoDTO) {
        var endereco = enderecoRepository.getReferenceById(enderecoDTO.getId());
        endereco.atualizarDados(enderecoDTO);
        enderecoRepository.save(endereco);
        System.out.println("Alteração efetuada com sucesso!");
    }

    public List<EnderecoDTO> gerarEnderecosDTOEmLote(int qtdeRuas, int qtdePredios, int qtdeApartamentos) {
        List<EnderecoDTO> listaEnderecos = new ArrayList<>();

        for(int rua = 1; rua<= qtdeRuas; rua++) {
            for(int predio = 1; predio<= qtdePredios; predio++) {
                for(int apartamento = 1; apartamento<= qtdeApartamentos; apartamento++) {
                    listaEnderecos.add(new EnderecoDTO(null, rua, predio, apartamento));
                }
            }
        }
        return listaEnderecos;
    }

    public StringBuilder geraScriptEmLote(List<EnderecoDTO> listaEnderecos) {
        StringBuilder sb = new StringBuilder();
        listaEnderecos.forEach(enderecoDTO -> {
            sb.append("INSERT INTO endereco (nr_rua, nr_predio, nr_apartamento) VALUES (");
            sb.append(enderecoDTO.getEnderecoCompleto());
            sb.append(");\n");
        });

        return sb;
    }

}