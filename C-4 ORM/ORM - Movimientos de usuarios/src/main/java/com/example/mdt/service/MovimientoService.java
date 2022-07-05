package com.example.mdt.service;

import com.example.mdt.persistance.entities.Movimiento;
import com.example.mdt.persistance.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    MovimientoRepository movimientoRepository;

    public String guardarMovimiento(Movimiento movimiento) {
        if (movimientoRepository.save(movimiento) != null) {
            return "OK";
        } else {
            return null;
        }
    }

    public List<Movimiento> mostrarTodos() {
        return movimientoRepository.findAll();
    }
}
