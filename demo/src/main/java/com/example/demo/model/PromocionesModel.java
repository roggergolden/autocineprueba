package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "promociones")
public class PromocionesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_promocion;

    @Column(name = "descripcion_promocion", nullable = false)
    private String descripcion_promocion;

    @Column(name = "porcentaje_descuento", nullable = false, precision = 5, scale = 2)
    private BigDecimal porcentaje_descuento;

    @Column(name = "id_producto")
    private Integer id_producto;

    @Column(name = "id_combo")
    private Integer id_combo;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fecha_inicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fecha_fin;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPromocion estado;

    // Enum para el estado de la promoción
    public enum EstadoPromocion {
        activo,
        inactivo
    }

    // Getters y Setters
    public Integer getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(Integer id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getDescripcion_promocion() {
        return descripcion_promocion;
    }

    public void setDescripcion_promocion(String descripcion_promocion) {
        this.descripcion_promocion = descripcion_promocion;
    }

    public BigDecimal getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(BigDecimal porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
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

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public EstadoPromocion getEstado() {
        return estado;
    }

    public void setEstado(EstadoPromocion estado) {
        this.estado = estado;
    }
}
