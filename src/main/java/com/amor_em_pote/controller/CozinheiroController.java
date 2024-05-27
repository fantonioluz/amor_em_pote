package com.amor_em_pote.controller;

import com.amor_em_pote.model.Cozinheiro;
import com.amor_em_pote.service.CozinheiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cozinheiros")
public class CozinheiroController {

    private final CozinheiroService cozinheiroService;

    @Autowired
    public CozinheiroController(CozinheiroService cozinheiroService) {
        this.cozinheiroService = cozinheiroService;
    }

    @GetMapping
    public List<Cozinheiro> getAllCozinheiros() {
        return cozinheiroService.getAllCozinheiros();
    }
}
