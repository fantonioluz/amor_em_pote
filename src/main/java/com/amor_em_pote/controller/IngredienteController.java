package com.amor_em_pote.controller;

import com.amor_em_pote.model.Ingrediente;
import com.amor_em_pote.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @PostMapping("/add")
    public void addIngrediente(@RequestBody Ingrediente ingrediente, @RequestParam String gerenteCodFuncionario) {
        ingredienteService.saveIngrediente(ingrediente, gerenteCodFuncionario);
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

    @PostMapping("/updateQuantidade")
    public void updateQuantidade(@RequestBody Map<String, String> payload) {
        int codIngrediente = Integer.parseInt(payload.get("codIngrediente"));
        int quantidade = Integer.parseInt(payload.get("quantidade"));
        String gerenteCodFuncionario = payload.get("gerenteCodFuncionario");
        ingredienteService.updateQuantidade(codIngrediente, quantidade, gerenteCodFuncionario);
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

    @GetMapping("/historico-compras")
    public List<Map<String, Object>> getCompraHistorico() {
        return ingredienteService.getCompraHistorico();
    }

}
