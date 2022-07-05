package com.example.mdt.persistance.repository;

import com.example.mdt.persistance.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
