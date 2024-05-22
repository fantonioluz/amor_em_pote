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

    public void saveFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public Funcionario getFuncionarioById(String codFuncionario) {
        try {
            return funcionarioRepository.findById(codFuncionario);
        } catch (Exception e) {
            // handle exception (e.g., funcionario not found)
            return null;
        }
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public void updateFuncionario(Funcionario funcionario) {
        funcionarioRepository.update(funcionario);
    }

    public void deleteFuncionarioById(String codFuncionario) {
        funcionarioRepository.delete(codFuncionario);
    }
}
