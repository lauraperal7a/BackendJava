package com.example.mdt.controller;

import com.example.mdt.persistance.entities.Producto;
import com.example.mdt.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<String> agregarProducto(@RequestBody Producto producto) {

        ResponseEntity<String> respuesta = null;

        if (productoService.guardarProducto(producto) != null) {
            respuesta = ResponseEntity.ok("El producto fue guardado con éxito");
        } else {
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }

    @GetMapping("/todos")
    public List<Producto> mostrarTodos() {
        return productoService.traerTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer id) {
        ResponseEntity<String> respuesta = null;

        if (productoService.eliminarProducto(id) != null) {
            respuesta = ResponseEntity.ok("El producto fue eliminado con éxito");
        } else {
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }
        return respuesta;
    }

}
