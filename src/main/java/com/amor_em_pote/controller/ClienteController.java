package com.amor_em_pote.controller;

import com.amor_em_pote.model.Cliente;
import com.amor_em_pote.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public void createCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);
    }

    @GetMapping("/{cpf}")
    public Cliente getCliente(@PathVariable String cpf) {
        Cliente cliente = clienteService.getClienteByCpf(cpf);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }
        return cliente;
    }

    @PutMapping("/{cpf}")
    public void updateCliente(@PathVariable String cpf, @RequestBody Cliente cliente) {
        cliente.setCpf(cpf);
        clienteService.updateCliente(cliente);
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @DeleteMapping("/{cpf}")
    public void deleteCliente(@PathVariable String cpf) {
        clienteService.deleteClienteByCpf(cpf);
    }
}
