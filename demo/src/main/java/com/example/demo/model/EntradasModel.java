package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "entradas")
public class EntradasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_entrada;

    @Column(name = "id_usuario", nullable = false)
    private Integer id_usuario;

    @Column(name = "id_funcion", nullable = false)
    private Integer id_funcion;

    @Column(name = "monto_pagado", precision = 10, scale = 2)
    private BigDecimal monto_pagado;

    @Column(name = "metodo_pago", nullable = false, length = 80)
    private String metodo_pago;

    @Column(name = "fecha_compra", nullable = false)
    private LocalDateTime fecha_compra;

    @Column(name = "estado_pago", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPago estado_pago;

    // Enum para el estado de pago
    public enum EstadoPago {
        completado,
        pendiente,
        fallido
    }

    // Getters y Setters

    public Integer getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(Integer id_entrada) {
        this.id_entrada = id_entrada;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(Integer id_funcion) {
        this.id_funcion = id_funcion;
    }

    public BigDecimal getMonto_pagado() {
        return monto_pagado;
    }

    public void setMonto_pagado(BigDecimal monto_pagado) {
        this.monto_pagado = monto_pagado;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public LocalDateTime getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(LocalDateTime fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public EstadoPago getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(EstadoPago estado_pago) {
        this.estado_pago = estado_pago;
    }
}
