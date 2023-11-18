package com.felintro.leonard.dto.pedido;

import com.felintro.leonard.dto.pessoa.EmpresaDTO;
import com.felintro.leonard.enums.StatusPedido;
import com.felintro.leonard.enums.TipoPedido;
import com.felintro.leonard.model.pedido.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author allan
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDTO {

    private Long nrPedido;
    private LocalDateTime dtHrEmissao;
    private EmpresaDTO empresaDTO;
    private List<PedidoProdutoDTO> produtosDTO = new ArrayList<>();
    private TipoPedido tipoPedido;
    private StatusPedido statusPedido;

    public PedidoDTO(Long nrPedido, LocalDateTime dtHrEmissao, EmpresaDTO empresaDTO, TipoPedido tipoPedido) {
        this.nrPedido = nrPedido;
        this.dtHrEmissao = dtHrEmissao;
        this.empresaDTO = empresaDTO;
        this.tipoPedido = tipoPedido;
    }

    public void adicionarProduto(PedidoProdutoDTO pedidoProdutoDTO) {
        pedidoProdutoDTO.setPedidoDTO(this);
        this.produtosDTO.add(pedidoProdutoDTO);
    }

    public Pedido toEntity() {
        Pedido pedido = new Pedido(this.dtHrEmissao, this.empresaDTO.toEntity(), this.tipoPedido, this.statusPedido);
        produtosDTO.forEach(pedidoProdutoDTO -> pedido.adicionarProduto(pedidoProdutoDTO.toEntity()));
        return pedido;
    }

    public String getDtHrEmissaoFormatada() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return this.dtHrEmissao.format(dateTimeFormatter);
    }

}