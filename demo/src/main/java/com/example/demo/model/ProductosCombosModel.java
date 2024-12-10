package com.example.demo.model;

import jakarta.persistence.*;

@Table(name = "productos_combos")
public class ProductosCombosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto_combo;

    @Column(name = "id_combo", nullable = false)
    private Integer id_combo;

    @Column(name = "id_producto", nullable = false)
    private Integer id_producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    // Getters y Setters

    public Integer getId_producto_combo() {
        return id_producto_combo;
    }

    public void setId_producto_combo(Integer id_producto_combo) {
        this.id_producto_combo = id_producto_combo;
    }

    public Integer getId_combo() {
        return id_combo;
    }

    public void setId_combo(Integer id_combo) {
        this.id_combo = id_combo;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
