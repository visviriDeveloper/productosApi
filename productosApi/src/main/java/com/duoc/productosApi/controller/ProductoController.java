package com.duoc.productosApi.controller;

import com.duoc.productosApi.model.Producto;
import com.duoc.productosApi.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/showAll?")
    public ResponseEntity<?> listarProductos() {
        try{
            List<Producto> productos = productoService.listar();
            return ResponseEntity.ok(productos); //Retorna estado 200
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al listar productos");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> agregarProducto(@RequestBody Producto producto) {
        try {
            if(producto.getId() == null || producto.getNombre() == null || producto.getPrecio() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al agregar producto\n" +
                        "Todos los campos son obligatorios.");
            }

            if (productoService.existePorId(producto.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El producto ya existe");
        }
            Producto newProducto = productoService.guardarProducto(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newProducto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar producto");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        try{
            if (!productoService.existePorId(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto no existe");
            }
            productoService.eliminarProducto(id);
            return ResponseEntity.ok("producto eliminado correctamente");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar producto");
        }
    }
}
