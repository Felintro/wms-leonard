package com.felintro.leonard.controller.pedido;

import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.service.estoque.ProdutoService;
import com.felintro.leonard.service.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pedido-compra")
public class PedidoCompraController {

    private static final String TELA_PEDIDO_COMPRA = "pedido/pedido-compra";
    private static final String REDIRECT_FORMULARIO = "redirect:/pedido-compra/formulario";

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        List<PedidoDTO> listaPedidoDTO = pedidoService.listarTodos()
            .stream()
            .filter(pedidoDTO -> pedidoDTO.getTipoPedido().equals(TipoPedido.COMPRA))
            .collect(Collectors.toList());

        model.addAttribute("listaPedidoDTO", listaPedidoDTO);
        return TELA_PEDIDO_COMPRA;
    }
















}
