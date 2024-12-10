package com.example.demo.controller;

import com.example.demo.model.AutosFuncionModel;
import com.example.demo.service.AutosFuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autos_funcion")
@CrossOrigin(origins = "http://localhost:3000")
public class AutosFuncionController {

    @Autowired
    private AutosFuncionService autosFuncionService;

    @GetMapping("/obtener")
    public List<AutosFuncionModel> obtenerAutosFuncion() {
        return autosFuncionService.obtenerAutosFuncion();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<AutosFuncionModel> obtenerAutoFuncionPorId(@PathVariable Integer id) {
        Optional<AutosFuncionModel> autoFuncion = autosFuncionService.obtenerAutoFuncionPorId(id);
        return autoFuncion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public AutosFuncionModel guardarAutoFuncion(@RequestBody AutosFuncionModel autoFuncion) {
        return autosFuncionService.guardarAutoFuncion(autoFuncion);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AutosFuncionModel> actualizarAutoFuncion(@PathVariable Integer id, @RequestBody AutosFuncionModel nuevoAutoFuncion) {
        AutosFuncionModel autoFuncionActualizado = autosFuncionService.actualizarAutoFuncion(id, nuevoAutoFuncion);
        return ResponseEntity.ok(autoFuncionActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarAutoFuncion(@PathVariable Integer id) {
        autosFuncionService.eliminarAutoFuncion(id);
        return ResponseEntity.noContent().build();
    }
}
