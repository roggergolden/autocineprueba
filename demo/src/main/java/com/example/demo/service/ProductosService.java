package com.example.demo.service;

import com.example.demo.model.ProductosModel;
import com.example.demo.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public List<ProductosModel> obtenerProductos() {
        return productosRepository.findAll();
    }

    public Optional<ProductosModel> obtenerProductoPorId(Integer id) {
        return productosRepository.findById(id);
    }

    public ProductosModel guardarProducto(ProductosModel producto) {
        return productosRepository.save(producto);
    }

    public void eliminarProducto(Integer id) {
        productosRepository.deleteById(id);
    }

    public ProductosModel actualizarProducto(Integer id, ProductosModel nuevoProducto) {
        return productosRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(nuevoProducto.getNombre());
                    producto.setDescripcion(nuevoProducto.getDescripcion());
                    producto.setPrecio(nuevoProducto.getPrecio());
                    producto.setTipo_producto(nuevoProducto.getTipo_producto());
                    producto.setStock(nuevoProducto.getStock());
                    producto.setImagen_url(nuevoProducto.getImagen_url());
                    return productosRepository.save(producto);
                }).orElseGet(() -> {
                    nuevoProducto.setId_producto(id);
                    return productosRepository.save(nuevoProducto);
                });
    }
}
