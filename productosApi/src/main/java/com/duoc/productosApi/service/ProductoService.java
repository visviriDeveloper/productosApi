package com.duoc.productosApi.service;

import com.duoc.productosApi.model.Producto;
import com.duoc.productosApi.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listar(){
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Integer id){
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public boolean existePorId(Integer id){
        return productoRepository.existsById(id);
    }

    public void eliminarProducto(Integer id){
        productoRepository.deleteById(id);
    }


}
