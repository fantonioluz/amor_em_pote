package com.amor_em_pote.controller;

import com.amor_em_pote.model.Funcionario;
import com.amor_em_pote.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public void createFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioService.saveFuncionario(funcionario);
    }

    @GetMapping("/{id}")
    public Funcionario getFuncionario(@PathVariable String id) {
        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        if (funcionario == null) {
            throw new RuntimeException("Funcionario não encontrado");
        }
        return funcionario;
    }

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    @PutMapping("/{id}")
    public void updateFuncionario(@PathVariable String id, @RequestBody Funcionario funcionario) {
        funcionario.setCod_funcionario(id);
        funcionarioService.updateFuncionario(funcionario);
    }

    @DeleteMapping("/{id}")
    public void deleteFuncionario(@PathVariable String id) {
        funcionarioService.deleteFuncionarioById(id);
    }
}
