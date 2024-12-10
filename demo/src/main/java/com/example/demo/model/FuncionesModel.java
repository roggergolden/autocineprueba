package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Table(name = "funciones")
public class FuncionesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_funcion;

    @Column(name = "id_pelicula", nullable = false)
    private Integer id_pelicula;

    @Column(name = "fecha_funcion", nullable = false)
    private Date fecha_funcion;

    @Column(name = "hora_inicio", nullable = false)
    private Time hora_inicio;

    @Column(name = "hora_fin", nullable = false)
    private Time hora_fin;

    @Column(name = "capacidad_autos", nullable = false)
    private Integer capacidad_autos;

    @Column(name = "estado_funcion", nullable = false)
    private String estado_funcion;

    @Column(name = "precio", precision = 10, scale = 2)
    private BigDecimal precio;

    // Getters y Setters
    public Integer getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(Integer id_funcion) {
        this.id_funcion = id_funcion;
    }

    public Integer getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Integer id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public Date getFecha_funcion() {
        return fecha_funcion;
    }

    public void setFecha_funcion(Date fecha_funcion) {
        this.fecha_funcion = fecha_funcion;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Integer getCapacidad_autos() {
        return capacidad_autos;
    }

    public void setCapacidad_autos(Integer capacidad_autos) {
        this.capacidad_autos = capacidad_autos;
    }

    public String getEstado_funcion() {
        return estado_funcion;
    }

    public void setEstado_funcion(String estado_funcion) {
        this.estado_funcion = estado_funcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}

