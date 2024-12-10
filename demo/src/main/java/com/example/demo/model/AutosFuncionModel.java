package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Table(name = "autos_funcion")
public class AutosFuncionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_auto_funcion;

    @Column(name = "id_funcion", nullable = false)
    private Integer id_funcion;

    @Column(name = "id_usuario", nullable = false)
    private Integer id_usuario;

    @Column(name = "placa_auto", nullable = false, length = 20)
    private String placa_auto;

    @Column(name = "hora_entrada", nullable = false)
    private LocalDateTime hora_entrada;

    @Column(name = "ubicacion_auto", length = 20)
    private String ubicacion_auto;

    // Getters y Setters

    public Integer getId_auto_funcion() {
        return id_auto_funcion;
    }

    public void setId_auto_funcion(Integer id_auto_funcion) {
        this.id_auto_funcion = id_auto_funcion;
    }

    public Integer getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(Integer id_funcion) {
        this.id_funcion = id_funcion;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPlaca_auto() {
        return placa_auto;
    }

    public void setPlaca_auto(String placa_auto) {
        this.placa_auto = placa_auto;
    }

    public LocalDateTime getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(LocalDateTime hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getUbicacion_auto() {
        return ubicacion_auto;
    }

    public void setUbicacion_auto(String ubicacion_auto) {
        this.ubicacion_auto = ubicacion_auto;
    }
}
