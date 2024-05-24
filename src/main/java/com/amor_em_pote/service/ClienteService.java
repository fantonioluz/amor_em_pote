package com.amor_em_pote.service;

import com.amor_em_pote.model.Cliente;
import com.amor_em_pote.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente getClienteByCpf(String cpf) {
        try {
            return clienteRepository.findById(cpf);
        } catch (Exception e) {
            // handle exception (e.g., cliente not found)
            return null;
        }
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public void updateCliente(Cliente cliente) {
        clienteRepository.update(cliente);
    }

    public void deleteClienteByCpf(String cpf) {
        clienteRepository.delete(cpf);
    }
}
