package com.felintro.leonard.service.pessoa;

import com.felintro.leonard.dto.pessoa.PessoaDTO;
import com.felintro.leonard.model.pessoa.Pessoa;
import com.felintro.leonard.repository.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    public void cadastrarPessoa(PessoaDTO pessoaDTO) {
        var isCadastrada = pessoaRepository.existsByNrCpf(pessoaDTO.getNrCpf());
        if(!isCadastrada) {
            Pessoa pessoa = pessoaDTO.toEntity();
            pessoaRepository.save(pessoa);
            System.out.println("Pessoa foi cadastrada com sucesso!");
            return;
        }
        System.out.println("A pessoa já existe!");
    }

    public void alterarPessoa(PessoaDTO pessoaDTO) {
        var pessoa = pessoaRepository.getReferenceById(pessoaDTO.getId());
        pessoa.atualizarDados(pessoaDTO);
        pessoaRepository.save(pessoa);
    }

    public List<PessoaDTO> listarPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaDTO> retorno = new ArrayList<>();
        pessoas.forEach(pessoa ->  retorno.add(pessoa.toDTO()));
        return retorno;
    }

    public PessoaDTO buscarPorNrCpf(String nrCpf) {
        return pessoaRepository.findByNrCpf(nrCpf).toDTO();
    }


    public PessoaDTO buscarPorId(Long id) {
        return pessoaRepository.getReferenceById(id).toDTO();
    }

}