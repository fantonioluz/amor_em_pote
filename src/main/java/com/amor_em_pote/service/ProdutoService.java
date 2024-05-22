package com.amor_em_pote.service;

import com.amor_em_pote.model.Produto;
import com.amor_em_pote.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void saveProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public Produto getProdutoByCod(int cod_produto) {
        try {
            return produtoRepository.findById(cod_produto);
        } catch (Exception e) {
            // handle exception (e.g., produto not found)
            return null;
        }
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public void deleteProdutoByCod(int cod_produto) {
        produtoRepository.delete(cod_produto);
    }
}
