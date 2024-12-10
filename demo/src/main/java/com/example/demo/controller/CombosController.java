package com.example.demo.controller;

import com.example.demo.model.CombosModel;
import com.example.demo.service.CombosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/combos")
@CrossOrigin(origins = "http://localhost:3000")
public class CombosController {

    @Autowired
    private CombosService combosService;

    @GetMapping("/obtener")
    public List<CombosModel> obtenerCombos() {
        return combosService.obtenerCombos();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<CombosModel> obtenerComboPorId(@PathVariable Integer id) {
        Optional<CombosModel> combo = combosService.obtenerComboPorId(id);
        return combo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public CombosModel guardarCombo(@RequestBody CombosModel combo) {
        return combosService.guardarCombo(combo);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CombosModel> actualizarCombo(@PathVariable Integer id, @RequestBody CombosModel nuevoCombo) {
        CombosModel comboActualizado = combosService.actualizarCombo(id, nuevoCombo);
        return ResponseEntity.ok(comboActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCombo(@PathVariable Integer id) {
        combosService.eliminarCombo(id);
        return ResponseEntity.noContent().build();
    }
}
