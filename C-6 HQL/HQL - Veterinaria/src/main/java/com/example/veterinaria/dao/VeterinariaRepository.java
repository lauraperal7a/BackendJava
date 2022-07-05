package com.example.veterinaria.dao;

import com.example.veterinaria.modelo.Veterinaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VeterinariaRepository extends JpaRepository<Veterinaria, Long> {

    
}
