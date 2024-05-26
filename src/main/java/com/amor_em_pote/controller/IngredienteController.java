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

    @PutMapping("/update/{cod_ingrediente}")
    public void updateQuantidade(@PathVariable int cod_ingrediente, @RequestBody Ingrediente ingrediente) {
        ingredienteService.updateQuantidade(cod_ingrediente, ingrediente.getQuantidade());
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
    @GetMapping("/orderByQuantidadeAsc")
    public List<Ingrediente> getIngredientesOrderByQuantidadeAsc() {
        return ingredienteService.getIngredientesOrderByQuantidadeAsc();
    }

    @GetMapping("/orderByQuantidadeDesc")
    public List<Ingrediente> getIngredientesOrderByQuantidadeDesc() {
        return ingredienteService.getIngredientesOrderByQuantidadeDesc();
    }

    @GetMapping("/orderByNomeAsc")
    public List<Ingrediente> getIngredientesOrderByNomeAsc() {
        return ingredienteService.getIngredientesOrderByNomeAsc();
    }

    @GetMapping("/orderByValorAsc")
    public List<Ingrediente> getIngredientesOrderByValorAsc() {
        return ingredienteService.getIngredientesOrderByValorAsc();
    }

    @GetMapping("/orderByValorDesc")
    public List<Ingrediente> getIngredientesOrderByValorDesc() {
        return ingredienteService.getIngredientesOrderByValorDesc();
    }


    @GetMapping("/alertas")
    public List<Ingrediente> getAlertasQuantidadeBaixa() {
        return ingredienteService.getIngredientesComQuantidadeBaixa();
    }
}
