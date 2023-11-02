package com.felintro.leonard.business.operacao;

import com.felintro.leonard.dto.operacao.MovimentacaoDTO;
import com.felintro.leonard.dto.operacao.RealizaMovimentacaoDTO;
import com.felintro.leonard.model.estoque.Endereco;
import com.felintro.leonard.model.estoque.Pack;
import com.felintro.leonard.model.operacao.Movimentacao;
import com.felintro.leonard.repository.estoque.ContainerRepository;
import com.felintro.leonard.repository.estoque.EnderecoRepository;
import com.felintro.leonard.repository.estoque.PackRepository;
import com.felintro.leonard.repository.operacao.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author allan
 **/

@Service
public class MovimentacaoBusiness {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    private PackRepository packRepository;

    public boolean realizaMovimentacao(RealizaMovimentacaoDTO movimentacaoDTO) {
        Endereco enderecoDestino = enderecoRepository.findByNrRuaAndNrPredioAndNrApartamento(movimentacaoDTO.getNrRuaDestino(), movimentacaoDTO.getNrPredioDestino(), movimentacaoDTO.getNrApartamentoDestino());
        Optional<Pack> pack = packRepository.findById(movimentacaoDTO.getNrPack());

        if(pack.isEmpty()) {
            System.out.println("O número do pack é inválido!");
            return false;
        }

        if(enderecoDestino == null) {
            System.out.println("O endereço informado está ocupado!");
            return false;
        }

        if(enderecoDestino.isOcupado()) {
            System.out.println("O endereço informado é inválido!");
            return false;
        }

        Endereco enderecoOrigem = enderecoRepository.findByNrPack(movimentacaoDTO.getNrPack());
        Movimentacao movimentacao = new Movimentacao(enderecoOrigem, enderecoDestino, pack.get(), LocalDateTime.now());

        enderecoOrigem.setPack(null);
        enderecoDestino.setPack(pack.get());

        movimentacaoRepository.save(movimentacao);
        enderecoRepository.save(enderecoOrigem);
        enderecoRepository.save(enderecoDestino);

        System.out.println("Operação realizada com sucesso!");
        return true;

    }

    public List<MovimentacaoDTO> listarMovimentacoes() {
        List<Movimentacao> movimentacaoList = movimentacaoRepository.findAll();
        List<MovimentacaoDTO> retorno = new ArrayList<>();
        movimentacaoList.forEach(movimentacao ->  retorno.add(movimentacao.toDTO()));
        return retorno;
    }

}