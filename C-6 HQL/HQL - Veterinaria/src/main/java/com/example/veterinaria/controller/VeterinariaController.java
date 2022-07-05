package com.example.veterinaria.controller;

import com.example.veterinaria.modelo.Veterinaria;
import com.example.veterinaria.service.impl.VeterinariaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {

    @Autowired
    VeterinariaServiceImpl veterinariaServiceImpl;

    @GetMapping()
    public List<Veterinaria> mostrarTodos() {
        return veterinariaServiceImpl.traerTodas();
    }

    @PostMapping("/crear")
    public ResponseEntity<String> agregarVeterinaria(@RequestBody Veterinaria veterinaria) {

        ResponseEntity<String> respuesta = null;
        veterinariaServiceImpl.crearVeterinaria(veterinaria);
        respuesta = ResponseEntity.ok("La veterinaria fue guardada con éxito");

        return respuesta;
    }
}
