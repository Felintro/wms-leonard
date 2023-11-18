package com.felintro.leonard.controller.operacao;

import com.felintro.leonard.business.operacao.RecebimentoBusiness;
import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.service.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author allan
 **/

@Controller
@RequestMapping("/recebimento")
public class RecebimentoController {

    private static final String TELA_RECEBIMENTO = "operacao/recebimento";
    private static final String TELA_INICIAL = "operacao/recebimento-pedidos";
    private static final String REDIRECT_FORMULARIO = "redirect:/recebimento/formulario";

    @Autowired
    private RecebimentoBusiness recebimentoBusiness;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/selecao-pedido")
    public String carregaPaginaInicial(Model model) {
        List<PedidoDTO> listaPedidoDTOS = pedidoService.buscarPorStatusETipo(StatusPedido.ABERTO, TipoPedido.COMPRA);
        model.addAttribute("listaPedidoDTOS", listaPedidoDTOS);
        return TELA_INICIAL;
    }

    @GetMapping("/pagina-inicial")
    public String carregaPaginaRecebimento(Model model) {


        return TELA_RECEBIMENTO;
    }

    public void receberProduto() {

    }

    public void estornarProduto() {

    }

    public void finalizarRecebimento() {

    }

}