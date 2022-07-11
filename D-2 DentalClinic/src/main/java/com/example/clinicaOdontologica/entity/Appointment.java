package com.example.clinicaOdontologica.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_sequence")
    @SequenceGenerator(name="appointment_sequence", sequenceName = "appointment_sequence", allocationSize = 1)
    @Column(name="id")
    private Integer id;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"dni", "entryDate", "address"})
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"licenseNumber"})
    @JoinColumn(name = "dentist_id", referencedColumnName = "id", nullable = false)
    private Dentist dentist;


    public Appointment() {
    }

    public Appointment(LocalDateTime dateTime, Patient patient, Dentist dentist) {
        this.dateTime = dateTime;
        this.patient = patient;
        this.dentist = dentist;
    }

    public Integer getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }
    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "Date and time=" + dateTime +
                ", patient=" + patient +
                ", dentist=" + dentist +
                '}';
    }
}
