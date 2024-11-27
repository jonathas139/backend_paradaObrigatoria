package com.example.parada_obrigatoria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parada_obrigatoria.repositories.AparelhoRepository;
import com.example.parada_obrigatoria.repositories.ClienteRepository;
import com.example.parada_obrigatoria.model.Aparelhos;
import com.example.parada_obrigatoria.model.Clientes;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para listar todos os clientes
    public List<Clientes> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    // Método para salvar cliente com aparelhos
    public Clientes salvarClienteComAparelhos(Clientes cliente) {
        List<Aparelhos> aparelhos = cliente.getAparelhos();
        
        if (aparelhos != null && !aparelhos.isEmpty()) {
            aparelhos.forEach(aparelho -> aparelho.setCliente(cliente));
        }

        return clienteRepository.save(cliente);  
    }
}
