package com.amor_em_pote.controller;

import com.amor_em_pote.model.Produto;
import com.amor_em_pote.repository.ProdutoRepository;
import com.amor_em_pote.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/add")
    public void addProduto(@RequestBody Map<String, Object> payload) {
        Produto produto = new Produto();
        produto.setNome_produto((String) payload.get("nome_produto"));
        produto.setDescricao((String) payload.get("descricao"));
        produto.setValor(Float.parseFloat(payload.get("valor").toString()));
        produto.setQuantidade(Integer.parseInt(payload.get("quantidade").toString()));

        // Converte os valores dos ingredientes para Integer
        Map<Integer, Integer> ingredientesUsados = ((Map<String, String>) payload.get("ingredientesUsados"))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> Integer.parseInt(e.getKey()),
                        e -> Integer.parseInt(e.getValue())
                ));

        produtoService.saveProdutoWithIngredientes(produto, ingredientesUsados);
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
