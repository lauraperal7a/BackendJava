package com.dh.productos.repository;

import com.dh.productos.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<Producto,Integer> {
}
