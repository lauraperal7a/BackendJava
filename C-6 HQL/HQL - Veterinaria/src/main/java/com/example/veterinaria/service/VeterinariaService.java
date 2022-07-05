package com.example.veterinaria.service;

import com.example.veterinaria.modelo.Veterinaria;

import java.util.List;

public interface VeterinariaService {

    List<Veterinaria> traerTodas();

    void crearVeterinaria(Veterinaria veterinaria);
}
