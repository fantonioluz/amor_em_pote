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
        return clienteRepository.findById(cpf);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public void deleteClienteByCpf(String cpf) {
        clienteRepository.delete(cpf);
    }
}
