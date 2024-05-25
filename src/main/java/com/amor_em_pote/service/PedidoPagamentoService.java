package com.amor_em_pote.service;

import com.amor_em_pote.model.PedidoPagamento;
import com.amor_em_pote.model.ProdutoPedido;
import com.amor_em_pote.repository.PedidoPagamentoRepository;
import com.amor_em_pote.repository.ProdutoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoPagamentoService {

    private final PedidoPagamentoRepository pedidoPagamentoRepository;
    private final ProdutoPedidoRepository produtoPedidoRepository;

    @Autowired
    public PedidoPagamentoService(PedidoPagamentoRepository pedidoPagamentoRepository, ProdutoPedidoRepository produtoPedidoRepository) {
        this.pedidoPagamentoRepository = pedidoPagamentoRepository;
        this.produtoPedidoRepository = produtoPedidoRepository;
    }

    @Transactional
    public void savePedidoWithProdutos(PedidoPagamento pedidoPagamento) {
        // Salva o pedido
        pedidoPagamentoRepository.save(pedidoPagamento);

        // Recupera o ID do pedido salvo
        int codPedido = pedidoPagamentoRepository.getLastInsertedId();

        // Salva os produtos associados ao pedido
        for (ProdutoPedido produtoPedido : pedidoPagamento.getProdutos()) {
            produtoPedido.setCod_pedido_fk(codPedido);
            produtoPedidoRepository.save(produtoPedido);
        }
    }

    public List<PedidoPagamento> getAllPedidosWithProducts() {
        return pedidoPagamentoRepository.findAllWithProducts();
    }
}
