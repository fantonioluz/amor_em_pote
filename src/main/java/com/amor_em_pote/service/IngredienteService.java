package com.amor_em_pote.service;

import com.amor_em_pote.model.Ingrediente;
import com.amor_em_pote.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public void saveIngrediente(Ingrediente ingrediente, String gerenteCodFuncionario) {
        ingredienteRepository.save(ingrediente, gerenteCodFuncionario);
    }

    public void updateQuantidade(int codIngrediente, int quantidade, String gerenteCodFuncionario) {
        ingredienteRepository.updateQuantidade(codIngrediente, quantidade, gerenteCodFuncionario);
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

    public List<Map<String, Object>> getCompraHistorico() {
        return ingredienteRepository.getCompraHistorico();
    }

}
