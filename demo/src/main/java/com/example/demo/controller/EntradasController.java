package com.example.demo.controller;

import com.example.demo.model.EntradasModel;
import com.example.demo.service.EntradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entradas")
@CrossOrigin(origins = "http://localhost:3000")
public class EntradasController {

    @Autowired
    private EntradasService entradasService;

    @GetMapping("/obtener")
    public List<EntradasModel> obtenerEntradas() {
        return entradasService.obtenerEntradas();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<EntradasModel> obtenerEntradaPorId(@PathVariable Integer id) {
        Optional<EntradasModel> entrada = entradasService.obtenerEntradaPorId(id);
        return entrada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public EntradasModel guardarEntrada(@RequestBody EntradasModel entrada) {
        return entradasService.guardarEntrada(entrada);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EntradasModel> actualizarEntrada(@PathVariable Integer id, @RequestBody EntradasModel nuevaEntrada) {
        EntradasModel entradaActualizada = entradasService.actualizarEntrada(id, nuevaEntrada);
        return ResponseEntity.ok(entradaActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEntrada(@PathVariable Integer id) {
        entradasService.eliminarEntrada(id);
        return ResponseEntity.noContent().build();
    }
}
