package com.amor_em_pote.service;

import com.amor_em_pote.model.Cliente;
import com.amor_em_pote.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(int id) {
        return clienteRepository.findById(id);
    }

    public void createCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void updateCliente(int id, Cliente cliente) {
        cliente.setCodCliente(id);
        clienteRepository.update(cliente);
    }

    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }
}
