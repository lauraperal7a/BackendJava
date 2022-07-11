package com.example.clinicaOdontologica.repository.impl;

import com.example.clinicaOdontologica.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

}
