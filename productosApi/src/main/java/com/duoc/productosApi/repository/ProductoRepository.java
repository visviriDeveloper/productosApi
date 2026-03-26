package com.duoc.productosApi.repository;

import com.duoc.productosApi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
