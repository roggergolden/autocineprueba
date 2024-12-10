package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "combos")
public class CombosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_combo;

    @Column(name = "nombre_combo", nullable = false)
    private String nombre_combo;

    @Column(name = "descripcion_combo")
    private String descripcion_combo;

    @Column(name = "precio_combo", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio_combo;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fecha_inicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fecha_fin;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoCombo estado;

    // Enum para el estado del combo
    public enum EstadoCombo {
        activo,
        inactivo
    }

    // Getters y Setters
    public Integer getId_combo() {
        return id_combo;
    }

    public void setId_combo(Integer id_combo) {
        this.id_combo = id_combo;
    }

    public String getNombre_combo() {
        return nombre_combo;
    }

    public void setNombre_combo(String nombre_combo) {
        this.nombre_combo = nombre_combo;
    }

    public String getDescripcion_combo() {
        return descripcion_combo;
    }

    public void setDescripcion_combo(String descripcion_combo) {
        this.descripcion_combo = descripcion_combo;
    }

    public BigDecimal getPrecio_combo() {
        return precio_combo;
    }

    public void setPrecio_combo(BigDecimal precio_combo) {
        this.precio_combo = precio_combo;
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

    public EstadoCombo getEstado() {
        return estado;
    }

    public void setEstado(EstadoCombo estado) {
        this.estado = estado;
    }
}
