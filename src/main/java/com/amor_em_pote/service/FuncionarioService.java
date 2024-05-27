package com.amor_em_pote.service;

import com.amor_em_pote.model.Funcionario;
import com.amor_em_pote.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void saveFuncionario(Funcionario funcionario, String tipo) {
        funcionarioRepository.save(funcionario, tipo);
    }

    public Funcionario getFuncionarioByCod(String codFuncionario) {
        return funcionarioRepository.findById(codFuncionario);
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public void updateFuncionario(Funcionario funcionario) {
        funcionarioRepository.update(funcionario);
    }

    public void deleteFuncionarioByCod(String codFuncionario) {
        funcionarioRepository.delete(codFuncionario);
    }
}

