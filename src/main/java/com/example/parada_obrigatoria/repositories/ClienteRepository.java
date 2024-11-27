package com.example.parada_obrigatoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parada_obrigatoria.model.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long>  {



}
