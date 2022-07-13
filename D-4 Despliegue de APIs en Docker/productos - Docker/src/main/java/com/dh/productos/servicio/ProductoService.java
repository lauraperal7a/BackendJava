package com.dh.productos.servicio;

import com.dh.productos.model.Producto;
import com.dh.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto guardar(Producto p){
        return productoRepository.save(p);
    }

    public List<Producto> listar(){
        return productoRepository.findAll();
    }
    public Producto buscar(Integer id){
        return productoRepository.findById(id).orElseGet(null);
    }
    public void eliminar(Integer id){
        productoRepository.deleteById(id);
    }
}
