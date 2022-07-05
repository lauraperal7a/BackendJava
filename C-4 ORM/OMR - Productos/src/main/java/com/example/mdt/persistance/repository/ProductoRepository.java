package com.example.mdt.persistance.repository;

import com.example.mdt.persistance.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
