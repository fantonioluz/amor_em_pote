package com.amor_em_pote.controller;

import com.amor_em_pote.service.ClienteService;
import com.amor_em_pote.service.PedidoPagamentoService;
import com.amor_em_pote.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    private final ClienteService clienteService;
    private final ProdutoService produtoService;
    private final PedidoPagamentoService pedidoPagamentoService;

    @Autowired
    public EstatisticasController(ClienteService clienteService, ProdutoService produtoService, PedidoPagamentoService pedidoPagamentoService) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.pedidoPagamentoService = pedidoPagamentoService;
    }

    @GetMapping
    public List<String> getEstatisticas() {
        List<String> estatisticas = new ArrayList<>();
        // Adicione suas estatísticas personalizadas aqui
        estatisticas.add("Número total de clientes: " + clienteService.getAllClientes().size());
        estatisticas.add("Número total de produtos: " + produtoService.getAllProdutos().size());
        estatisticas.add("Pedidos realizados no último mês: " + pedidoPagamentoService.getPedidosNoUltimoMes().size());
        // Adicione mais estatísticas conforme necessário
        return estatisticas;
    }
}
