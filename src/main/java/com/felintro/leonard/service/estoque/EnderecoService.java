package com.felintro.leonard.service.estoque;

import com.felintro.leonard.dto.EnderecoDTO;
import com.felintro.leonard.model.estoque.Endereco;
import com.felintro.leonard.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@Service
@RequestMapping("/endereco")
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void cadastrarEndereco(EnderecoDTO enderecoDTO) {
        var endereco = enderecoDTO.toEntity();
        enderecoRepository.save(endereco);

    }

    public List<EnderecoDTO> listarEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        List<EnderecoDTO> retorno = new ArrayList<>();
        enderecos.forEach(endereco -> {
            retorno.add(endereco.toDTO());
        });

        return retorno;
    }

}