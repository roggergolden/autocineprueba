package com.example.demo.service;

import com.example.demo.model.ProductosCombosModel;
import com.example.demo.repository.ProductosCombosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosCombosService {

    @Autowired
    private ProductosCombosRepository productosCombosRepository;

    public List<ProductosCombosModel> obtenerProductosCombos() {
        return productosCombosRepository.findAll();
    }

    public Optional<ProductosCombosModel> obtenerProductoComboPorId(Integer id) {
        return productosCombosRepository.findById(id);
    }

    public ProductosCombosModel guardarProductoCombo(ProductosCombosModel productoCombo) {
        return productosCombosRepository.save(productoCombo);
    }

    public void eliminarProductoCombo(Integer id) {
        productosCombosRepository.deleteById(id);
    }

    public ProductosCombosModel actualizarProductoCombo(Integer id, ProductosCombosModel nuevoProductoCombo) {
        return productosCombosRepository.findById(id)
                .map(productoCombo -> {
                    productoCombo.setId_combo(nuevoProductoCombo.getId_combo());
                    productoCombo.setId_producto(nuevoProductoCombo.getId_producto());
                    productoCombo.setCantidad(nuevoProductoCombo.getCantidad());
                    return productosCombosRepository.save(productoCombo);
                }).orElseGet(() -> {
                    nuevoProductoCombo.setId_producto_combo(id);
                    return productosCombosRepository.save(nuevoProductoCombo);
                });
    }
}
