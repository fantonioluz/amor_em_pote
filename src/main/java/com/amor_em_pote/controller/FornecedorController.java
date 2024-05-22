package com.amor_em_pote.controller;

import com.amor_em_pote.model.Fornecedor;
import com.amor_em_pote.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping("/add")
    public void addFornecedor(@RequestBody Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

    @GetMapping("/{cod_fornecedor}")
    public Fornecedor getFornecedorByCod(@PathVariable int cod_fornecedor) {
        return fornecedorRepository.findById(cod_fornecedor);
    }

    @GetMapping("/all")
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    @DeleteMapping("/{cod_fornecedor}")
    public void deleteFornecedor(@PathVariable int cod_fornecedor) {
        fornecedorRepository.delete(cod_fornecedor);
    }
}

