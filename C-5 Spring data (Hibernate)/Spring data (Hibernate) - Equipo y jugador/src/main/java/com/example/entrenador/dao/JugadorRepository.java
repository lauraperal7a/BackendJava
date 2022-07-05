package com.example.entrenador.dao;

import com.example.entrenador.modelo.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
