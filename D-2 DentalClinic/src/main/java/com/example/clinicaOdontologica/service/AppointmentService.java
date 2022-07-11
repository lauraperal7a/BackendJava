package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.Appointment;
import com.example.clinicaOdontologica.repository.impl.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IEntityService<Appointment> {
    private IAppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> findById(Integer id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment update(Appointment appointment) {
        Appointment app = appointmentRepository.getById(appointment.getId());
        app.setDateTime(appointment.getDateTime());
        app.setDentist(appointment.getDentist());
        app.setPatient(appointment.getPatient());
        appointmentRepository.save(app);
        return app;
    }

    @Override
    public void delete(Integer id) {
        Appointment app = appointmentRepository.getById(id);
        appointmentRepository.delete(app);
    }
}
