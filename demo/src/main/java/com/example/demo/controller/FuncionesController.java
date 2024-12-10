package com.example.demo.controller;

import com.example.demo.model.FuncionesModel;
import com.example.demo.service.FuncionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funciones")  
@CrossOrigin(origins = "http://localhost:3000")
public class FuncionesController {

    @Autowired
    private FuncionesService funcionesService;

    @GetMapping("/obtener")
    public List<FuncionesModel> obtenerFunciones() {
        return funcionesService.obtenerFunciones();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<FuncionesModel> obtenerFuncionPorId(@PathVariable Integer id) {
        Optional<FuncionesModel> funcion = funcionesService.obtenerFuncionPorId(id);
        return funcion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public FuncionesModel guardarFuncion(@RequestBody FuncionesModel funcion) {
        return funcionesService.guardarFuncion(funcion);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<FuncionesModel> actualizarFuncion(@PathVariable Integer id, @RequestBody FuncionesModel nuevaFuncion) {
        FuncionesModel funcionActualizada = funcionesService.actualizarFuncion(id, nuevaFuncion);
        return ResponseEntity.ok(funcionActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarFuncion(@PathVariable Integer id) {
        funcionesService.eliminarFuncion(id);
        return ResponseEntity.noContent().build();
    }
}
