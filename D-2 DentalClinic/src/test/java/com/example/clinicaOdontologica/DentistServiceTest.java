package com.example.clinicaOdontologica;

import com.example.clinicaOdontologica.entity.Dentist;
import com.example.clinicaOdontologica.service.DentistService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DentistServiceTest {

    @Autowired
    DentistService dentistService;
    Dentist dentist;

    @BeforeEach
    void init() {
        dentist = new Dentist("774411", "Felipe", "Montero");
    }

    @Test
    @Order(1)
    @DisplayName("Save a dentist")
    void saveDentist() {
        Dentist den = dentistService.save(dentist);
        Assertions.assertNotNull(den);
    }

    @Test
    @Order(2)
    @DisplayName("Find a dentist by ID")
    void findDentistById() {
        Dentist den = dentistService.findById(1).orElse(null);
        Assertions.assertNotNull(den);
    }

    @Test
    @Order(3)
    @DisplayName("Delete a dentist")
    void deleteDentist() {
        Dentist den = dentistService.findById(1).orElse(null);
        dentistService.delete(den.getId());
        Dentist result = dentistService.findById(1).orElse(null);
        Assertions.assertNull(result);
    }

    @Test
    @Order(4)
    @DisplayName("List all dentists")
    void listAllDentists() {
        Dentist dentist2 = new Dentist("996633", "Rosa", "Rojas");
        dentistService.save(dentist);
        dentistService.save(dentist2);
        List<Dentist> dentists = dentistService.findAll();
        Assertions.assertTrue(dentists.size() == 2);
        Assertions.assertFalse(dentists.isEmpty());
    }
}
