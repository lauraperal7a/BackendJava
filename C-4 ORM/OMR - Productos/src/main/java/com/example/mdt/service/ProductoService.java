package com.example.mdt.service;

import com.example.mdt.persistance.entities.Producto;
import com.example.mdt.persistance.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public String guardarProducto(Producto producto) {
        if (productoRepository.save(producto) != null) {
            return "Producto guardado correctamente";
        } else {
            return null;
        }
    }

    public List<Producto> traerTodos() {
        return productoRepository.findAll();
    }

    public String eliminarProducto(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return "Producto eliminado correctamente";
        } else {
            return null;
        }
    }

}
