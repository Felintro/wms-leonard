package com.felintro.leonard.controller.operacao;

import com.felintro.leonard.business.operacao.ExpedicaoBusiness;
import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.service.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author allan
 **/

@Controller
@RequestMapping("/expedicao")
public class ExpedicaoController {

    private static final String TELA_EXPEDICAO = "operacao/expedicao/expedicao";
    private static final String TELA_INICIAL = "operacao/expedicao/selecao-cliente";
    private static final String REDIRECT_FORMULARIO = "redirect:/expedicao/formulario";
    private static final String REDIRECT_TELA_INICIAL = "redirect:/expedicao/selecao-pedido";

    @Autowired
    private ExpedicaoBusiness expedicaoBusiness;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/selecao-cliente")
    public String carregaPaginaInicial(Model model) {
        List<PedidoDTO> listaPedidosConcluidosDTO = pedidoService.buscarPorStatusETipo(StatusPedido.CONCLUIDO, TipoPedido.VENDA);
        model.addAttribute("listaPedidosConcluidosDTO", listaPedidosConcluidosDTO);
        return TELA_INICIAL;
    }

    @PostMapping("/expedir")
    @Transactional
    public String expedirContainer() {
        return "";
    }

    @PostMapping("/finalizar")
    @Transactional
    public String finalizarExpedicao() {
        return "";
    }


}