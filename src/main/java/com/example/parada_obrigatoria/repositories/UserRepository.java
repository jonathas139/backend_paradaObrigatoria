package com.example.parada_obrigatoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parada_obrigatoria.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
