package com.amor_em_pote.controller;

import com.amor_em_pote.model.Entrega;
import com.amor_em_pote.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService entregaService;

    @Autowired
    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @PostMapping
    public void createEntrega(@RequestBody Entrega entrega) {
        entregaService.saveEntrega(entrega);
    }

    @GetMapping
    public List<Entrega> getAllEntregas() {
        return entregaService.getAllEntregas();
    }
}
