package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.entity.Appointment;
import com.example.clinicaOdontologica.service.AppointmentService;
import com.example.clinicaOdontologica.service.DentistService;
import com.example.clinicaOdontologica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;
    private PatientService patientService;
    private DentistService dentistService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, PatientService patientService, DentistService dentistService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.dentistService = dentistService;
    }

    //GET
    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> findAll() {
        return new ResponseEntity<>(appointmentService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable("id") int appointmentId) {
        if (appointmentService.findById(appointmentId).isPresent()) {
            return new ResponseEntity(appointmentService.findById(appointmentId), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //POST
    @PostMapping("/save")
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {
        if(dentistService.findById(appointment.getDentist().getId()).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else if (patientService.findById(appointment.getPatient().getId()).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(appointmentService.save(appointment), HttpStatus.CREATED);
        }
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int appointmentId) {
        if (appointmentService.findById(appointmentId).isPresent()) {
            appointmentService.delete(appointmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //UPDATE
    @PutMapping("/update")
    public ResponseEntity<Appointment> update(@RequestBody Appointment appointment) {
        if (appointmentService.findById(appointment.getId()).isPresent()) {
            return new ResponseEntity<>(appointmentService.update(appointment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
