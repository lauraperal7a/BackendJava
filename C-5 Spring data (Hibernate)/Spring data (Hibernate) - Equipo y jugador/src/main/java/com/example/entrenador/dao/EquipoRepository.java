package com.example.entrenador.dao;

import com.example.entrenador.modelo.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
