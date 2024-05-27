package com.amor_em_pote.service;

import com.amor_em_pote.model.ProdutoPedido;
import com.amor_em_pote.repository.ProdutoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoPedidoService {

    private final ProdutoPedidoRepository produtoPedidoRepository;

    @Autowired
    public ProdutoPedidoService(ProdutoPedidoRepository produtoPedidoRepository) {
        this.produtoPedidoRepository = produtoPedidoRepository;
    }

    public void saveProdutoPedido(ProdutoPedido produtoPedido) {
        produtoPedidoRepository.save(produtoPedido);
    }

    public List<ProdutoPedido> getProdutosByPedidoId(int cod_pedido_fk) {
        return produtoPedidoRepository.findByPedidoId(cod_pedido_fk);
    }
    public List<ProdutoPedido> getProdutosMaisBaratos() {
        return produtoPedidoRepository.findProdutosMaisBaratos();
    }

    public List<ProdutoPedido> getProdutosMaisCaros() {
        return produtoPedidoRepository.findProdutosMaisCaros();
    }

    public List<ProdutoPedido> getProdutosMaiorQuantidade() {
        return produtoPedidoRepository.findProdutosMaiorQuantidade();
    }

    public List<ProdutoPedido> getProdutosMenorQuantidade() {
        return produtoPedidoRepository.findProdutosMenorQuantidade();
    }

    public List<ProdutoPedido> getProdutosOrdemAlfabetica() {
        return produtoPedidoRepository.findProdutosOrdemAlfabetica();
    }

    public List<ProdutoPedido> getProdutosMaisPedidosCrescente() {
        return produtoPedidoRepository.findProdutosMaisPedidosCrescente();
    }
}
