package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Table(name = "detalle_pedidos")
public class DetallePedidosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_pedido;

    @Column(name = "id_pedido", nullable = false)
    private Integer id_pedido;

    @Column(name = "id_producto")
    private Integer id_producto;

    @Column(name = "id_combo")
    private Integer id_combo;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio_unitario;

    // Getters y Setters

    public Integer getId_detalle_pedido() {
        return id_detalle_pedido;
    }

    public void setId_detalle_pedido(Integer id_detalle_pedido) {
        this.id_detalle_pedido = id_detalle_pedido;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getId_combo() {
        return id_combo;
    }

    public void setId_combo(Integer id_combo) {
        this.id_combo = id_combo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
}
