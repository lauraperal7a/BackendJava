package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.exception.DniException;

import java.util.List;
import java.util.Optional;

public interface IEntityService<T> {
    T save(T t) throws DniException;
    Optional<T> findById(Integer id);
    List<T> findAll();
    T update(T t);
    void delete(Integer id);
}
