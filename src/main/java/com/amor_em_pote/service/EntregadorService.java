package com.amor_em_pote.service;

import com.amor_em_pote.model.Entregador;
import com.amor_em_pote.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregadorService {

    private final EntregadorRepository entregadorRepository;

    @Autowired
    public EntregadorService(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    public void saveEntregador(Entregador entregador) {
        entregadorRepository.save(entregador);
    }

    public Entregador getEntregadorByCod(String cod_entregador) {
        return entregadorRepository.findById(cod_entregador);
    }

    public List<Entregador> getAllEntregadores() {
        return entregadorRepository.findAll();
    }

    public void deleteEntregadorByCod(String cod_entregador) {
        entregadorRepository.delete(cod_entregador);
    }
}
