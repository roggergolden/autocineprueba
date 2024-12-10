package com.example.demo.service;

import com.example.demo.model.DetallePedidosModel;
import com.example.demo.repository.DetallePedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidosService {

    @Autowired
    private DetallePedidosRepository detallePedidosRepository;

    public List<DetallePedidosModel> obtenerDetallePedidos() {
        return detallePedidosRepository.findAll();
    }

    public Optional<DetallePedidosModel> obtenerDetallePedidoPorId(Integer id) {
        return detallePedidosRepository.findById(id);
    }

    public DetallePedidosModel guardarDetallePedido(DetallePedidosModel detallePedido) {
        return detallePedidosRepository.save(detallePedido);
    }

    public void eliminarDetallePedido(Integer id) {
        detallePedidosRepository.deleteById(id);
    }

    public DetallePedidosModel actualizarDetallePedido(Integer id, DetallePedidosModel nuevoDetallePedido) {
        return detallePedidosRepository.findById(id)
                .map(detallePedido -> {
                    detallePedido.setId_pedido(nuevoDetallePedido.getId_pedido());
                    detallePedido.setId_producto(nuevoDetallePedido.getId_producto());
                    detallePedido.setId_combo(nuevoDetallePedido.getId_combo());
                    detallePedido.setCantidad(nuevoDetallePedido.getCantidad());
                    detallePedido.setPrecio_unitario(nuevoDetallePedido.getPrecio_unitario());
                    return detallePedidosRepository.save(detallePedido);
                }).orElseGet(() -> {
                    nuevoDetallePedido.setId_detalle_pedido(id);
                    return detallePedidosRepository.save(nuevoDetallePedido);
                });
    }
}
