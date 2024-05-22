package com.amor_em_pote.service;

import com.amor_em_pote.model.Fornecedor;
import com.amor_em_pote.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public void saveFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

    public Fornecedor getFornecedorByCod(int cod_fornecedor) {
        try {
            return fornecedorRepository.findById(cod_fornecedor);
        } catch (Exception e) {
            // handle exception (e.g., fornecedor not found)
            return null;
        }
    }

    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    public void deleteFornecedorByCod(int cod_fornecedor) {
        fornecedorRepository.delete(cod_fornecedor);
    }
}

