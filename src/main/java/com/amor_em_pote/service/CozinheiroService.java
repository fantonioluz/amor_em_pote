package com.amor_em_pote.service;

import com.amor_em_pote.model.Cozinheiro;
import com.amor_em_pote.repository.CozinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinheiroService {

    private final CozinheiroRepository cozinheiroRepository;

    @Autowired
    public CozinheiroService(CozinheiroRepository cozinheiroRepository) {
        this.cozinheiroRepository = cozinheiroRepository;
    }

    public List<Cozinheiro> getAllCozinheiros() {
        return cozinheiroRepository.findAll();
    }
}
