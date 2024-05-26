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

    @GetMapping("/data/{date}")
    public List<PedidoPagamento> findByDateWithDetails(@PathVariable String date) {
        // Retorna os pedidos de uma determinada data com detalhes
        return pedidoPagamentoService.findByDateWithDetails(date);
    }

    @GetMapping("/mes/{month}")
    public List<PedidoPagamento> findByMonthWithDetails(@PathVariable String month) {
        // Retorna os pedidos de um determinado mês com detalhes
        return pedidoPagamentoService.findByMonthWithDetails(month);
    }

    @GetMapping("/ano/{year}")
    public List<PedidoPagamento> findByYearWithDetails(@PathVariable String year) {
        // Retorna os pedidos de um determinado ano com detalhes
        return pedidoPagamentoService.findByYearWithDetails(year);
    }
}
