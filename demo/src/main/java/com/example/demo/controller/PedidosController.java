package com.example.demo.controller;

import com.example.demo.model.PedidosModel;
import com.example.demo.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping("/obtener")
    public List<PedidosModel> obtenerPedidos() {
        return pedidosService.obtenerPedidos();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<PedidosModel> obtenerPedidoPorId(@PathVariable Integer id) {
        Optional<PedidosModel> pedido = pedidosService.obtenerPedidoPorId(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public PedidosModel guardarPedido(@RequestBody PedidosModel pedido) {
        return pedidosService.guardarPedido(pedido);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PedidosModel> actualizarPedido(@PathVariable Integer id, @RequestBody PedidosModel nuevoPedido) {
        PedidosModel pedidoActualizado = pedidosService.actualizarPedido(id, nuevoPedido);
        return ResponseEntity.ok(pedidoActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer id) {
        pedidosService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
