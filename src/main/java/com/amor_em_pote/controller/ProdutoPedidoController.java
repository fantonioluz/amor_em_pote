package com.amor_em_pote.controller;

import com.amor_em_pote.model.ProdutoPedido;
import com.amor_em_pote.service.ProdutoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto_pedido")
public class ProdutoPedidoController {

    @Autowired
    private ProdutoPedidoService produtoPedidoService;

    @PostMapping("/add")
    public void addProdutoPedido(@RequestBody ProdutoPedido produtoPedido) {
        produtoPedidoService.saveProdutoPedido(produtoPedido);
    }

    @GetMapping("/pedido/{cod_pedido_fk}")
    public List<ProdutoPedido> getProdutosByPedidoId(@PathVariable int cod_pedido_fk) {
        return produtoPedidoService.getProdutosByPedidoId(cod_pedido_fk);
    }
}
