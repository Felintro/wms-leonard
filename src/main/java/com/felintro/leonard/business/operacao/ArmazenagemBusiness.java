package com.felintro.leonard.business.operacao;

import com.felintro.leonard.dto.estoque.PackDTO;
import com.felintro.leonard.dto.operacao.RealizaMovimentacaoDTO;
import com.felintro.leonard.model.estoque.Endereco;
import com.felintro.leonard.model.estoque.Pack;
import com.felintro.leonard.model.operacao.Armazenagem;
import com.felintro.leonard.repository.estoque.EnderecoRepository;
import com.felintro.leonard.repository.estoque.PackRepository;
import com.felintro.leonard.repository.operacao.ArmazenagemRepository;
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
public class ArmazenagemBusiness {

    @Autowired
    private ArmazenagemRepository armazenagemRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PackRepository packRepository;

    public boolean realizaArmazenagem(RealizaMovimentacaoDTO realizaMovimentacaoDTO) {
        Endereco enderecoDestino = enderecoRepository.findByNrRuaAndNrPredioAndNrApartamento(realizaMovimentacaoDTO.getNrRuaDestino(), realizaMovimentacaoDTO.getNrPredioDestino(), realizaMovimentacaoDTO.getNrApartamentoDestino());
        Optional<Pack> pack = packRepository.findById(realizaMovimentacaoDTO.getNrPack());

        if(pack.isEmpty()) {
            System.out.println("O número do pack é inválido!");
            return false;
        }

        if(enderecoDestino == null) {
            System.out.println("O endereço informado é inválido!");
            return false;
        }

        if(enderecoDestino.isOcupado()) {
            System.out.println("O endereço informado está ocupado!");
            return false;
        }

        enderecoDestino.setPack(pack.get());
        enderecoRepository.save(enderecoDestino);

        Armazenagem armazenagem = new Armazenagem(enderecoDestino, pack.get(), LocalDateTime.now());
        armazenagemRepository.save(armazenagem);

        return true;
    }

    public List<PackDTO> listarPacksPendentesDeArmazenagem() {
        List<Pack> packList = packRepository.findAllPacksWithoutEndereco();
        List<PackDTO> retorno = new ArrayList<>();
        packList.forEach(pack ->  retorno.add(pack.toDTO()));
        return retorno;
    }

}