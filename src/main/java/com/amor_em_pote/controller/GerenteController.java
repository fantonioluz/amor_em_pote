package com.amor_em_pote.controller;

import com.amor_em_pote.model.Gerente;
import com.amor_em_pote.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    private final GerenteService gerenteService;

    @Autowired
    public GerenteController(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }

    @GetMapping
    public List<Gerente> getAllGerentes() {
        return gerenteService.getAllGerentes();
    }
}
