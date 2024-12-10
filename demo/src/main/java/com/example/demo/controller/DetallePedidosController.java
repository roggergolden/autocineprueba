package com.example.demo.controller;

import com.example.demo.model.DetallePedidosModel;
import com.example.demo.service.DetallePedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle_pedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class DetallePedidosController {

    @Autowired
    private DetallePedidosService detallePedidosService;

    @GetMapping("/obtener")
    public List<DetallePedidosModel> obtenerDetallePedidos() {
        return detallePedidosService.obtenerDetallePedidos();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<DetallePedidosModel> obtenerDetallePedidoPorId(@PathVariable Integer id) {
        Optional<DetallePedidosModel> detallePedido = detallePedidosService.obtenerDetallePedidoPorId(id);
        return detallePedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public DetallePedidosModel guardarDetallePedido(@RequestBody DetallePedidosModel detallePedido) {
        return detallePedidosService.guardarDetallePedido(detallePedido);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DetallePedidosModel> actualizarDetallePedido(@PathVariable Integer id, @RequestBody DetallePedidosModel nuevoDetallePedido) {
        DetallePedidosModel detallePedidoActualizado = detallePedidosService.actualizarDetallePedido(id, nuevoDetallePedido);
        return ResponseEntity.ok(detallePedidoActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDetallePedido(@PathVariable Integer id) {
        detallePedidosService.eliminarDetallePedido(id);
        return ResponseEntity.noContent().build();
    }
}
