package com.amor_em_pote.service;

import com.amor_em_pote.model.Entrega;
import com.amor_em_pote.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;

    @Autowired
    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public void saveEntrega(Entrega entrega) {
        entregaRepository.save(entrega);
    }

    public List<Entrega> getAllEntregas() {
        return entregaRepository.findAll();
    }
}
