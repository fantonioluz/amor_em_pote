package com.amor_em_pote.controller;

import com.amor_em_pote.model.Produto;
import com.amor_em_pote.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/add")
    public void addProduto(@RequestBody Produto produto) {
        produtoRepository.save(produto);
    }

    @GetMapping("/{cod_produto}")
    public Produto getProdutoByCod(@PathVariable int cod_produto) {
        return produtoRepository.findById(cod_produto);
    }

    @GetMapping("/all")
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @DeleteMapping("/{cod_produto}")
    public void deleteProduto(@PathVariable int cod_produto) {
        produtoRepository.delete(cod_produto);
    }
}
