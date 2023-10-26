package com.felintro.leonard.controller.pessoa;

import com.felintro.leonard.dto.pessoa.EmpresaDTO;
import com.felintro.leonard.service.pessoa.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author allan
 **/
@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    private static final String REDIRECT_VISUALIZAR = "redirect:/empresa/visualizar";

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if(id != null) {
            var empresaDTO = empresaService.buscarPorId(id);
            model.addAttribute("empresaDTO", empresaDTO);
        }
        return "cadastro/cadastro-empresa";
    }

    @PostMapping("/cadastrar")
    @Transactional
    public String cadastrarEmpresa(EmpresaDTO empresaDTO) {
        empresaService.cadastrarEmpresa(empresaDTO);
        return REDIRECT_VISUALIZAR;
    }

    @PutMapping("/cadastrar")
    @Transactional
    public String alterarEmpresa(EmpresaDTO empresaDTO) {
        empresaService.alterarEmpresa(empresaDTO);
        return REDIRECT_VISUALIZAR;
    }

    @GetMapping("/visualizar")
    public String listarEmpresas(Model model) {
        List<EmpresaDTO> listaDTO = empresaService.listarEmpresas();
        model.addAttribute("listaDTO", listaDTO);
        return "view/view-empresa";
    }

}