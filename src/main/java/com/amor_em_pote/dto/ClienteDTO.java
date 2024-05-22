package com.amor_em_pote.dto;

import com.amor_em_pote.model.Cliente;
import com.amor_em_pote.model.Telefone;
import java.util.List;

public class ClienteDTO {
    private Cliente cliente;
    private List<Telefone> telefones;

    // Getters e setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
