package com.amor_em_pote.controller;

import com.amor_em_pote.model.PedidoPagamento;
import com.amor_em_pote.service.PedidoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/ultimos")
    public List<PedidoPagamento> getUltimosPedidos() {
        return pedidoPagamentoService.getAllPedidosWithProducts().stream()
                .sorted((p1, p2) -> p2.getData_pedido().compareTo(p1.getData_pedido()))
                .limit(5)
                .collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<PedidoPagamento> getAllPedidosWithProducts() {
        return pedidoPagamentoService.getAllPedidosWithProducts();
    }
}
