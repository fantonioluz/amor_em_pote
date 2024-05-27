package com.amor_em_pote.service;

import com.amor_em_pote.model.Gerente;
import com.amor_em_pote.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {

    private final GerenteRepository gerenteRepository;

    @Autowired
    public GerenteService(GerenteRepository gerenteRepository) {
        this.gerenteRepository = gerenteRepository;
    }

    public List<Gerente> getAllGerentes() {
        return gerenteRepository.findAll();
    }
}
