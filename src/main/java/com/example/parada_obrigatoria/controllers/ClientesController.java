package com.example.parada_obrigatoria.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parada_obrigatoria.model.Clientes;
import com.example.parada_obrigatoria.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    
    
     private final ClienteService clienteService;

    // Injeção de dependência via construtor
    @Autowired
    public ClientesController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/salvar")
    public Clientes salvarClienteComAparelhos(@RequestBody Clientes cliente) {
        return clienteService.salvarClienteComAparelhos(cliente);
    }

     @GetMapping
    public List<Clientes> listarTodosClientes() {
        return clienteService.listarTodosClientes();
    }
}
