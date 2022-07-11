package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.entity.Patient;
import com.example.clinicaOdontologica.exception.DniException;
import com.example.clinicaOdontologica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //GET
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> findAll() {
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable("id") int patientId) {
        if(patientService.findById(patientId).isPresent()) {
            return new ResponseEntity(patientService.findById(patientId), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //POST
    @PostMapping("/save")
    public ResponseEntity<Patient> save(@RequestBody Patient patient) throws DniException {
        return new ResponseEntity<>(patientService.save(patient), HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int patientId) {
        if (patientService.findById(patientId).isPresent()) {
            patientService.delete(patientId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //UPDATE
    @PutMapping("/update")
    public ResponseEntity<Patient> update(@RequestBody Patient patient) {
        if (patientService.findById(patient.getId()).isPresent()) {
            return new ResponseEntity<>(patientService.update(patient), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
