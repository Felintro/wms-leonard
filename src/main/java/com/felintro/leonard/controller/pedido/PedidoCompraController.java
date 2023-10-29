package com.felintro.leonard.controller.pedido;

import com.felintro.leonard.dto.pedido.RegistraPedidoDTO;
import com.felintro.leonard.dto.pedido.PedidoDTO;
import com.felintro.leonard.service.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido-compra")
public class PedidoCompraController {

    private static final String PEDIDO_REGISTRADO = "Pedido registrado com sucesso!";
    private static final String PEDIDO_CANCELADO = "Pedido cancelado com sucesso!";

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/registrar")
    public ResponseEntity registrarPedidoCompra(@RequestBody RegistraPedidoDTO registraPedidoDTO) {
        pedidoService.registrarPedido(registraPedidoDTO);
        return new ResponseEntity(PEDIDO_REGISTRADO, HttpStatus.OK);
    }

    @PostMapping("/cancelar")
    public ResponseEntity cancelarPedidoCompra(@RequestBody Long nrPedido) {
        pedidoService.cancelarPedido(nrPedido);
        return new ResponseEntity(PEDIDO_CANCELADO, HttpStatus.OK);
    }

}