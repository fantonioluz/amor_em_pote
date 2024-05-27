package com.amor_em_pote.service;

import com.amor_em_pote.model.Produto;
import com.amor_em_pote.repository.IngredienteRepository;
import com.amor_em_pote.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ProdutoService {

    private static ProdutoRepository produtoRepository = null;
    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, IngredienteRepository ingredienteRepository) {
        this.produtoRepository = produtoRepository;
        this.ingredienteRepository = ingredienteRepository;
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


    public static List<Produto> getAvailableProducts() {
        return produtoRepository.findAvailableProducts();
    }


    public static List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public void updateProduto(Produto produto) {
        produtoRepository.update(produto);
    }

    public void deleteProdutoByCod(int cod_produto) {
        produtoRepository.delete(cod_produto);
    }

    @Transactional
    public void saveProdutoWithIngredientes(Produto produto, Map<Integer, Integer> ingredientesUsados) {
        // Salva o produto
        produtoRepository.save(produto);

        // Atualiza o estoque dos ingredientes
        for (Map.Entry<Integer, Integer> entry : ingredientesUsados.entrySet()) {
            int codIngrediente = entry.getKey();
            int quantidade = entry.getValue();
            ingredienteRepository.usoIngrediente(codIngrediente, -quantidade);
        }
    }
}
