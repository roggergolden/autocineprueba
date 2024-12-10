package com.example.demo.controller;

import com.example.demo.model.ProductosModel;
import com.example.demo.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:3000") 
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    
    @GetMapping("/obtener")
    public List<ProductosModel> obtenerProductos() {
        return productosService.obtenerProductos();
    }

   
    @GetMapping("/obtener/{id}")
    public ResponseEntity<ProductosModel> obtenerProductoPorId(@PathVariable Integer id) {
        Optional<ProductosModel> producto = productosService.obtenerProductoPorId(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Insertar un nuevo producto (Cambiar de "guardar" a "insertar" para consistencia)
    @PostMapping("/insertar")
    public ResponseEntity<ProductosModel> insertarProducto(@RequestBody ProductosModel producto) {
        try {
            ProductosModel productoGuardado = productosService.guardarProducto(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); 
        }
    }

    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductosModel> actualizarProducto(@PathVariable Integer id, @RequestBody ProductosModel nuevoProducto) {
        try {
            ProductosModel productoActualizado = productosService.actualizarProducto(id, nuevoProducto);
            return ResponseEntity.ok(productoActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        try {
            productosService.eliminarProducto(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content si se elimina correctamente
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
