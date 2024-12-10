package com.example.demo.controller;

import com.example.demo.model.ProductosCombosModel;
import com.example.demo.service.ProductosCombosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos_combos")
public class ProductosCombosController {

    @Autowired
    private ProductosCombosService productosCombosService;

    @GetMapping("/obtener")
    public List<ProductosCombosModel> obtenerProductosCombos() {
        return productosCombosService.obtenerProductosCombos();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<ProductosCombosModel> obtenerProductoComboPorId(@PathVariable Integer id) {
        Optional<ProductosCombosModel> productoCombo = productosCombosService.obtenerProductoComboPorId(id);
        return productoCombo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ProductosCombosModel guardarProductoCombo(@RequestBody ProductosCombosModel productoCombo) {
        return productosCombosService.guardarProductoCombo(productoCombo);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductosCombosModel> actualizarProductoCombo(@PathVariable Integer id, @RequestBody ProductosCombosModel nuevoProductoCombo) {
        ProductosCombosModel productoComboActualizado = productosCombosService.actualizarProductoCombo(id, nuevoProductoCombo);
        return ResponseEntity.ok(productoComboActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProductoCombo(@PathVariable Integer id) {
        productosCombosService.eliminarProductoCombo(id);
        return ResponseEntity.noContent().build();
    }
}
