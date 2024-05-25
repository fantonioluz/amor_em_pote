package com.amor_em_pote.controller;

import com.amor_em_pote.model.Produto;
import com.amor_em_pote.repository.ProdutoRepository;
import com.amor_em_pote.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoService produtoService) {
    }

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

    @PutMapping("/{cod_produto}")
    public void updateProduto(@PathVariable int cod_produto, @RequestBody Produto produto) {
        produto.setCod_produto(cod_produto);
        produtoRepository.update(produto);
    }

    @GetMapping("/available")
    public List<Produto> getAvailableProducts() {
        return ProdutoService.getAvailableProducts();
    }

    @GetMapping("/estoque")
    public List<Produto> getProdutosEmEstoque() {
        return ProdutoService.getAllProdutos().stream()
                .filter(produto -> produto.getQuantidade() > 0)
                .collect(Collectors.toList());
    }




    @DeleteMapping("/{cod_produto}")
    public void deleteProduto(@PathVariable int cod_produto) {
        produtoRepository.delete(cod_produto);
    }
}
