package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.entity.Dentist;
import com.example.clinicaOdontologica.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dentists")
public class DentistController {

    private DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    //GET
    @GetMapping("/all")
    public ResponseEntity<List<Dentist>> findAll() {
        return new ResponseEntity<>(dentistService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Dentist> findById(@PathVariable("id") int dentistId) {
        if (dentistService.findById(dentistId).isPresent()) {
            return new ResponseEntity(dentistService.findById(dentistId), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //POST
    @PostMapping("/save")
    public ResponseEntity<Dentist> save(@RequestBody Dentist dentist) {
        return new ResponseEntity<>(dentistService.save(dentist), HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int dentistId) {
        if (dentistService.findById(dentistId).isPresent()) {
            dentistService.delete(dentistId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //UPDATE
    @PutMapping("/update")
    public ResponseEntity<Dentist> update(@RequestBody Dentist dentist) {
        if (dentistService.findById(dentist.getId()).isPresent()) {
            return new ResponseEntity<>(dentistService.update(dentist), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
