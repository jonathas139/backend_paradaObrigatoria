package com.example.parada_obrigatoria;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.parada_obrigatoria.model.Aparelhos;
import com.example.parada_obrigatoria.model.Clientes;
import com.example.parada_obrigatoria.repositories.AparelhoRepository;
import com.example.parada_obrigatoria.repositories.ClienteRepository;

@SpringBootApplication
public class ParadaObrigatoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParadaObrigatoriaApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabse( ClienteRepository clienteRepository, AparelhoRepository aparelhoRepository ){
		return args -> {
            clienteRepository.deleteAll(); // Limpar os dados anteriores

            // Criando o cliente João
            Clientes c1 = new Clientes();
            c1.setNome("João");  // Nome do cliente

            // Salvar o cliente primeiro para garantir que ele tenha um ID
            clienteRepository.save(c1);

            // Criando um aparelho para o João
            Aparelhos aparelho = new Aparelhos();
            aparelho.setNome("Aparelho de Teste");  // Nome do aparelho
            aparelho.setCliente(c1);  // Associa o aparelho ao cliente João

            // Salvar o aparelho no banco
            aparelhoRepository.save(aparelho);

            // Associar o aparelho à lista de aparelhos do cliente
            c1.setAparelhos(Arrays.asList(aparelho));  // Lista com o novo aparelho

            // Atualizar o cliente no banco com a lista de aparelhos
            clienteRepository.save(c1);
        };
	}

}
