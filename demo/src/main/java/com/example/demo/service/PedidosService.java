package com.example.demo.service;

import com.example.demo.model.PedidosModel;
import com.example.demo.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    public List<PedidosModel> obtenerPedidos() {
        return pedidosRepository.findAll();
    }

    public Optional<PedidosModel> obtenerPedidoPorId(Integer id) {
        return pedidosRepository.findById(id);
    }

    public PedidosModel guardarPedido(PedidosModel pedido) {
        return pedidosRepository.save(pedido);
    }

    public void eliminarPedido(Integer id) {
        pedidosRepository.deleteById(id);
    }

    public PedidosModel actualizarPedido(Integer id, PedidosModel nuevoPedido) {
        return pedidosRepository.findById(id)
                .map(pedido -> {
                    pedido.setId_usuario(nuevoPedido.getId_usuario());
                    pedido.setFecha_pedido(nuevoPedido.getFecha_pedido());
                    pedido.setTotal(nuevoPedido.getTotal());
                    pedido.setEstado_pedido(nuevoPedido.getEstado_pedido());
                    pedido.setMetodo_pago(nuevoPedido.getMetodo_pago());
                    return pedidosRepository.save(pedido);
                }).orElseGet(() -> {
                    nuevoPedido.setId_pedido(id);
                    return pedidosRepository.save(nuevoPedido);
                });
    }
}
