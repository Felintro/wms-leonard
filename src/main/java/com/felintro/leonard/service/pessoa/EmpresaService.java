package com.felintro.leonard.service.pessoa;

import com.felintro.leonard.dto.pessoa.EmpresaDTO;
import com.felintro.leonard.model.pessoa.Empresa;
import com.felintro.leonard.repository.pessoa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public void cadastrarEmpresa(EmpresaDTO empresaDTO) {
        var isCadastrada = empresaRepository.existsByNrCnpj(empresaDTO.getNrCnpj());
        if(!isCadastrada) {
            Empresa empresa = empresaDTO.toEntity();
            empresaRepository.save(empresa);
            System.out.println("Empresa foi cadastrada com sucesso!");
            return;
        }
        System.out.println("A empresa já existe!");
    }

    public void alterarEmpresa(EmpresaDTO empresaDTO) {
        var empresa = empresaRepository.getReferenceById(empresaDTO.getId());
        empresa.atualizarDados(empresaDTO);
        empresaRepository.save(empresa);
    }

    public List<EmpresaDTO> listarEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        List<EmpresaDTO> retorno = new ArrayList<>();
        empresas.forEach(empresa ->  retorno.add(empresa.toDTO()));
        return retorno;
    }

    public EmpresaDTO buscarPorNrCnpj(String nrCnpj) {
        return empresaRepository.findByNrCnpj(nrCnpj).toDTO();
    }

    public EmpresaDTO buscarPorId(Long id) {
        return empresaRepository.getReferenceById(id).toDTO();
    }
}