package com.example.veterinaria.service.impl;

import com.example.veterinaria.dao.VeterinariaRepository;
import com.example.veterinaria.modelo.Veterinaria;
import com.example.veterinaria.service.VeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinariaServiceImpl implements VeterinariaService {

    @Autowired
    VeterinariaRepository veterinariaRepository;

    @Override
    public List<Veterinaria> traerTodas() {
        return veterinariaRepository.findAll();
    }

    @Override
    public void crearVeterinaria(Veterinaria veterinaria) {
        veterinariaRepository.save(veterinaria);
    }

}
