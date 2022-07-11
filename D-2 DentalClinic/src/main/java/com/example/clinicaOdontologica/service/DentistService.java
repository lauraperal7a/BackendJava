package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.Dentist;
import com.example.clinicaOdontologica.repository.impl.IDentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService implements IEntityService<Dentist> {

    private IDentistRepository dentistRepository;

    @Autowired
    public DentistService(IDentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist save(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Optional<Dentist> findById(Integer id) {
        return dentistRepository.findById(id);
    }

    @Override
    public List<Dentist> findAll() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist update(Dentist dentist) {
        Dentist den = dentistRepository.getById(dentist.getId());
        den.setName(dentist.getName());
        den.setLastName(dentist.getLastName());
        den.setLicenseNumber(dentist.getLicenseNumber());
        dentistRepository.save(den);
        return den;
    }

    @Override
    public void delete(Integer id) {
        Dentist den = dentistRepository.getById(id);
        dentistRepository.delete(den);
    }
}
