package com.example.mdt.controller;

import com.example.mdt.persistance.entities.Movimiento;
import com.example.mdt.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    MovimientoService movimientoService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody Movimiento movimiento) {

        ResponseEntity<String> respuesta = null;

        if (movimientoService.guardarMovimiento(movimiento) != null) {
            respuesta = ResponseEntity.ok("El movimiento fue registrado con éxito");
        } else {
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Movimiento>> consultarTodos() {
        return ResponseEntity.ok(movimientoService.mostrarTodos());
    }
}
