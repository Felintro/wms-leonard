package com.felintro.leonard.controller.operacao;

import com.felintro.leonard.business.operacao.RecebimentoBusiness;
import com.felintro.leonard.dto.operacao.ReceberProdutoDTO;
import com.felintro.leonard.dto.operacao.RecebimentoDTO;
import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.dto.pedido.PedidoProdutoDTO;
import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.model.operacao.Recebimento;
import com.felintro.leonard.service.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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
        List<PedidoDTO> listaPedidosAbertosDTO = pedidoService.buscarPorStatusETipo(StatusPedido.ABERTO, TipoPedido.COMPRA);
        List<PedidoDTO> listaPedidosRecebidosDTO = pedidoService.buscarPorStatusETipo(StatusPedido.RECEBIDO, TipoPedido.COMPRA);

        model.addAttribute("listaPedidosAbertosDTO", listaPedidosAbertosDTO);
        model.addAttribute("listaPedidosRecebidosDTO", listaPedidosRecebidosDTO);

        return TELA_INICIAL;
    }

    @GetMapping("/formulario")
    public String carregaPaginaRecebimento(Long nrPedido, Model model) {
        List<PedidoProdutoDTO> pedidoProdutoDTOList = pedidoService.buscarProdutosPorNrPedido(nrPedido);
        Optional<Recebimento> optRecebimento = recebimentoBusiness.buscarPorNrPedido(nrPedido);

        if(optRecebimento.isPresent()){
            RecebimentoDTO recebimentoDTO = optRecebimento.get().toDTO();
            model.addAttribute("recebimentoDTO", recebimentoDTO);
        }

        model.addAttribute("nrPedido", nrPedido);
        model.addAttribute("pedidoProdutoDTOList", pedidoProdutoDTOList);
        return TELA_RECEBIMENTO;
    }

    /*@RequestMapping("/receber/{nrPedido}/{nrPack}/{nrEan13}/{qtde}")
    public String receberProduto(@RequestParam("nrPedido") Long nrPedido,
                                 @RequestParam("nrPack") Long nrPack,
                                 @RequestParam("nrEan13") String nrEan13,
                                 @RequestParam("qtde") int qtde) {

        recebimentoBusiness.receberProduto(nrPedido, nrEan13, qtde);
        return REDIRECT_FORMULARIO;
    }*/

    @PostMapping("/receber")
    public String receberProduto(ReceberProdutoDTO receberProdutoDTO) {
        boolean isOperacaoFinalizada = recebimentoBusiness.receberProduto(receberProdutoDTO);
        return REDIRECT_FORMULARIO+"?nrPedido="+receberProdutoDTO.getNrPedido();
    }

    @RequestMapping("/estornar/{nrPedido}/{nrPack}/{nrEan13}")
    public String estornarProduto(@RequestParam("nrPedido") Long nrPedido,
                                  @RequestParam("nrPack") Long nrPack,
                                  @RequestParam("nrEan13") String nrEan13) {

        recebimentoBusiness.estornarProduto(nrPedido, nrPack, nrEan13);

        return REDIRECT_FORMULARIO;
    }

    public void finalizarRecebimento() {

    }

}