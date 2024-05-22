package com.amor_em_pote.controller;

import com.amor_em_pote.model.Entregador;
import com.amor_em_pote.service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    private final EntregadorService entregadorService;

    @Autowired
    public EntregadorController(EntregadorService entregadorService) {
        this.entregadorService = entregadorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addEntregador(@RequestBody Entregador entregador) {
        entregadorService.saveEntregador(entregador);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{cod_entregador}")
    public ResponseEntity<Entregador> getEntregadorByCod(@PathVariable String cod_entregador) {
        Entregador entregador = entregadorService.getEntregadorByCod(cod_entregador);
        return entregador != null ? ResponseEntity.ok(entregador) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public List<Entregador> getAllEntregadores() {
        return entregadorService.getAllEntregadores();
    }

    @DeleteMapping("/{cod_entregador}")
    public ResponseEntity<Void> deleteEntregador(@PathVariable String cod_entregador) {
        entregadorService.deleteEntregadorByCod(cod_entregador);
        return ResponseEntity.noContent().build();
    }
}
