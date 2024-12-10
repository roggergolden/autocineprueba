package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "pedidos")
public class PedidosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @Column(name = "id_usuario", nullable = false)
    private Integer id_usuario;

    @Column(name = "fecha_pedido", nullable = false)
    private LocalDateTime fecha_pedido;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "estado_pedido", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado_pedido;

    @Column(name = "metodo_pago", nullable = false)
    private String metodo_pago;

    // Enum para el estado del pedido
    public enum EstadoPedido {
        pendiente,
        completado,
        cancelado
    }

    // Getters y Setters
    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDateTime getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(LocalDateTime fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public EstadoPedido getEstado_pedido() {
        return estado_pedido;
    }

    public void setEstado_pedido(EstadoPedido estado_pedido) {
        this.estado_pedido = estado_pedido;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
}
