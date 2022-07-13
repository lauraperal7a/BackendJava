package com.dh.paqueteria.controller;

import com.dh.paqueteria.exceptions.BadRequestException;
import com.dh.paqueteria.model.Paquete;
import com.dh.paqueteria.service.PaqueteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

    private PaqueteService paqueteService;

    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @PostMapping
    public Paquete registar(@RequestBody Paquete paquete) throws BadRequestException {
        return paqueteService.agregar(paquete);
    }

    @GetMapping
    public List<Paquete> listar() {
        return paqueteService.listar();
    }

    @GetMapping("/en-camino")
    public List<Paquete> enCamino() {
        return paqueteService.paquetesEnCamino();
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
