package com.example.clinicaOdontologica.repository.impl;

import com.example.clinicaOdontologica.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {
}
