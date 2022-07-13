package com.dh.productos.controller;

import com.dh.productos.model.Producto;
import com.dh.productos.servicio.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {


    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Registrar un nuevo producto")
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto p){
        return productoService.guardar(p);
    }
    @Operation(summary = "Ver todos los productos")
    @GetMapping
    public List<Producto> listar(){
        return productoService.listar();
    }
    @Operation(summary = "Eliminar productos por id")
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        productoService.eliminar(id);
        return "eliminado";
    }
    @Operation(summary = "Buscar productos por id")
    @GetMapping("/{id}")
    public  Producto buscar(@PathVariable Integer id){
        return productoService.buscar(id);
    }
}
