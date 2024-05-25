package com.amor_em_pote.controller;

import com.amor_em_pote.model.PedidoPagamento;
import com.amor_em_pote.service.PedidoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoPagamentoController {

    private final PedidoPagamentoService pedidoPagamentoService;

    @Autowired
    public PedidoPagamentoController(PedidoPagamentoService pedidoPagamentoService) {
        this.pedidoPagamentoService = pedidoPagamentoService;
    }

    @PostMapping("/add")
    public void addPedido(@RequestBody PedidoPagamento pedidoPagamento) {
        pedidoPagamentoService.savePedidoWithProdutos(pedidoPagamento);
    }

    @GetMapping("/all")
    public List<PedidoPagamento> getAllPedidosWithProducts() {
        return pedidoPagamentoService.getAllPedidosWithProducts();
    }
}
