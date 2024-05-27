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
    public void addFuncionario(@RequestBody FuncionarioRequest request) {
        Funcionario funcionario = new Funcionario(request.getCod_funcionario(), request.getSalario(), request.getExpediente(), request.getNome());
        funcionarioService.saveFuncionario(funcionario, request.getTipo());
    }

    @GetMapping("/{codFuncionario}")
    public Funcionario getFuncionarioByCod(@PathVariable String codFuncionario) {
        return funcionarioService.getFuncionarioByCod(codFuncionario);
    }

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    @PutMapping("/{codFuncionario}")
    public void updateFuncionario(@PathVariable String codFuncionario, @RequestBody Funcionario funcionario) {
        funcionario.setCod_funcionario(codFuncionario);
        funcionarioService.updateFuncionario(funcionario);
    }

    @DeleteMapping("/{codFuncionario}")
    public void deleteFuncionarioByCod(@PathVariable String codFuncionario) {
        funcionarioService.deleteFuncionarioByCod(codFuncionario);
    }

    public static class FuncionarioRequest {
        private String cod_funcionario;
        private int salario;
        private String expediente;
        private String nome;
        private String tipo;

        public String getCod_funcionario() {
            return cod_funcionario;
        }

        public void setCod_funcionario(String cod_funcionario) {
            this.cod_funcionario = cod_funcionario;
        }

        public int getSalario() {
            return salario;
        }

        public void setSalario(int salario) {
            this.salario = salario;
        }

        public String getExpediente() {
            return expediente;
        }

        public void setExpediente(String expediente) {
            this.expediente = expediente;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }
}

