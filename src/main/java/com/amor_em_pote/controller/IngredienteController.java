package com.amor_em_pote.controller;

import com.amor_em_pote.model.Ingrediente;
import com.amor_em_pote.repository.IngredienteRepository;
import com.amor_em_pote.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;
    private IngredienteRepository ingredienteRepository;

    @PostMapping("/add")
    public void addIngrediente(@RequestBody Ingrediente ingrediente) {
        ingredienteService.saveIngrediente(ingrediente);
    }

    @GetMapping("/{cod_ingrediente}")
    public Ingrediente getIngredienteByCod(@PathVariable int cod_ingrediente) {
        return ingredienteService.getIngredienteByCod(cod_ingrediente);
    }

    @GetMapping("/all")
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteService.getAllIngredientes();
    }

    @GetMapping("/disponiveis")
    public List<Ingrediente> getAllIngredientesDisponiveis() {
        return ingredienteService.findAllWithQuantidadeGreaterThanZero();
    }

    @DeleteMapping("/{cod_ingrediente}")
    public void deleteIngredienteByCod(@PathVariable int cod_ingrediente) {
        ingredienteService.deleteIngredienteByCod(cod_ingrediente);
    }
}
