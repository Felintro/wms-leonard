package com.felintro.leonard.controller.operacao;

import com.felintro.leonard.business.operacao.SeparacaoBusiness;
import com.felintro.leonard.dto.estoque.ContainerDTO;
import com.felintro.leonard.dto.estoque.ContainerProdutoDTO;
import com.felintro.leonard.dto.operacao.FinalizarContainerDTO;
import com.felintro.leonard.dto.operacao.SeparacaoDTO;
import com.felintro.leonard.dto.operacao.SepararProdutoDTO;
import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.dto.pedido.PedidoProdutoDTO;
import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.model.operacao.Separacao;
import com.felintro.leonard.service.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author allan
 **/

@Controller
@RequestMapping("/separacao")
public class SeparacaoController {

    private static final String TELA_SEPARACAO = "operacao/separacao/separacao";
    private static final String TELA_INICIAL = "operacao/separacao/selecao-pedidos";
    private static final String REDIRECT_FORMULARIO = "redirect:/separacao/formulario";
    private static final String REDIRECT_TELA_INICIAL = "redirect:/separacao/selecao-pedido";

    @Autowired
    private SeparacaoBusiness separacaoBusiness;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/selecao-pedido")
    public String carregaPaginaInicial(Model model) {
        List<PedidoDTO> listaPedidosAbertosDTO = pedidoService.buscarPorStatusETipo(StatusPedido.ABERTO, TipoPedido.VENDA);
        List<PedidoDTO> listaPedidosSeparadosDTO = pedidoService.buscarPorStatusETipo(StatusPedido.CONCLUIDO, TipoPedido.VENDA);

        model.addAttribute("listaPedidosAbertosDTO", listaPedidosAbertosDTO);
        model.addAttribute("listaPedidosSeparadosDTO", listaPedidosSeparadosDTO);

        return TELA_INICIAL;
    }

    @GetMapping("/formulario")
    public String carregaPaginaSeparacao(Long nrPedido, Model model) {
        List<PedidoProdutoDTO> produtosPendentesDTOList = pedidoService.buscarProdutosPorNrPedido(nrPedido);
        Optional<Separacao> optSeparacao = separacaoBusiness.buscarPorNrPedido(nrPedido);

        if(optSeparacao.isPresent()) {
            SeparacaoDTO separacaoDTO = optSeparacao.get().toDTO();
            List<ContainerDTO> containerFinalizadoDTOList = separacaoDTO.getContainerList()
                .stream()
                .filter(containerDTO -> containerDTO.getEnderecoDTO() != null)
                .collect(Collectors.toList());

            separacaoDTO.getContainerList()
                .stream()
                .flatMap(containerDTO -> containerDTO.getContainerProdutosDTO().stream())
                .map(ContainerProdutoDTO::getProdutoDTO)
                .forEach(
                    produtoSeparadoDTO -> produtosPendentesDTOList.removeIf(
                        produtoPendenteDTO -> produtoPendenteDTO.getProdutoDTO().getId().equals(produtoSeparadoDTO.getId())
                    )
                );

            model.addAttribute("separacaoDTO", separacaoDTO);
            model.addAttribute("containerFinalizadoDTOList", containerFinalizadoDTOList);
        }

        model.addAttribute("nrPedido", nrPedido);
        model.addAttribute("produtosPendentesDTOList", produtosPendentesDTOList);

        return TELA_SEPARACAO;
    }

    @PostMapping("/separar")
    @Transactional
    public String separarProduto(SepararProdutoDTO separarProdutoDTO) {
        separacaoBusiness.separarProduto(separarProdutoDTO);
        return REDIRECT_FORMULARIO + "?nrPedido=" + separarProdutoDTO.getNrPedido();
    }

    @PostMapping("/finalizar-container")
    @Transactional
    public String finalizarContainer(FinalizarContainerDTO finalizarContainerDTO) {
        boolean isOperacaoFinalizada = separacaoBusiness.finalizarContainer(finalizarContainerDTO);
        return isOperacaoFinalizada ? REDIRECT_TELA_INICIAL : REDIRECT_FORMULARIO + "?nrPedido=" + finalizarContainerDTO.getNrPedidoSeparacao();
    }

}