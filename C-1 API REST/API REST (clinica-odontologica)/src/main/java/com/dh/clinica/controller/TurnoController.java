package com.dh.clinica.controller;

import com.dh.clinica.model.Odontologo;
import com.dh.clinica.repository.impl.DomicilioDaoH2;
import com.dh.clinica.repository.impl.OdontologoDaoH2;
import com.dh.clinica.repository.impl.PacienteDaoH2;
import com.dh.clinica.repository.impl.TurnoListRepository;
import com.dh.clinica.model.Turno;
import com.dh.clinica.service.OdontologoService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {


    private TurnoService turnoService = new TurnoService(new TurnoListRepository());
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @PostMapping("/new")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;
        if (pacienteService.buscar(turno.getPaciente().getId()) != null && odontologoService.buscar(turno.getOdontologo().getId()) != null)
            response = ResponseEntity.ok(turnoService.registrarTurno(turno));

        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;


    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Integer id) {
        Turno turno = turnoService.buscar(id);

        return ResponseEntity.ok(turno);
    }

    @PutMapping("/update")
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) {
        ResponseEntity<Turno> response = null;

        if (turno.getId() != null && turnoService.buscar(turno.getId()) != null)
            response = ResponseEntity.ok(turnoService.actualizar(turno));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (turnoService.buscar(id) != null) {
            turnoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;}


    @GetMapping
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.listar());
    }



}
