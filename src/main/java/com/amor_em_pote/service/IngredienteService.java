package com.amor_em_pote.service;

import com.amor_em_pote.model.Ingrediente;
import com.amor_em_pote.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public void saveIngrediente(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    public void updateQuantidade(int cod_ingrediente, int quantidade) {
        ingredienteRepository.updateQuantidade(cod_ingrediente, quantidade);
    }

    public Ingrediente getIngredienteByCod(int cod_ingrediente) {
        try {
            return ingredienteRepository.findById(cod_ingrediente);
        } catch (Exception e) {
            // handle exception (e.g., ingrediente not found)
            return null;
        }
    }

    public List<Ingrediente> getIngredientesComQuantidadeBaixa() {
        return ingredienteRepository.findIngredientesComQuantidadeBaixa();
    }

    public List<Ingrediente> findAllWithQuantidadeGreaterThanZero() {
        return ingredienteRepository.findAllWithQuantidadeGreaterThanZero();
    }

    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    public void deleteIngredienteByCod(int cod_ingrediente) {
        ingredienteRepository.delete(cod_ingrediente);
    }
    public List<Ingrediente> getIngredientesOrderByQuantidadeAsc() {
        return ingredienteRepository.findAllOrderByQuantidadeAsc();
    }

    public List<Ingrediente> getIngredientesOrderByQuantidadeDesc() {
        return ingredienteRepository.findAllOrderByQuantidadeDesc();
    }

    public List<Ingrediente> getIngredientesOrderByNomeAsc() {
        return ingredienteRepository.findAllOrderByNomeAsc();
    }

    public List<Ingrediente> getIngredientesOrderByValorAsc() {
        return ingredienteRepository.findAllOrderByValorAsc();
    }

    public List<Ingrediente> getIngredientesOrderByValorDesc() {
        return ingredienteRepository.findAllOrderByValorDesc();
    }
}
