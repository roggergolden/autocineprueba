package com.example.demo.controller;

import com.example.demo.model.PromocionesModel;
import com.example.demo.service.PromocionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promociones")
@CrossOrigin(origins = "http://localhost:3000")
public class PromocionesController {

    @Autowired
    private PromocionesService promocionesService;

    @GetMapping("/obtener")
    public List<PromocionesModel> obtenerPromociones() {
        return promocionesService.obtenerPromociones();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<PromocionesModel> obtenerPromocionPorId(@PathVariable Integer id) {
        Optional<PromocionesModel> promocion = promocionesService.obtenerPromocionPorId(id);
        return promocion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public PromocionesModel guardarPromocion(@RequestBody PromocionesModel promocion) {
        return promocionesService.guardarPromocion(promocion);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PromocionesModel> actualizarPromocion(@PathVariable Integer id, @RequestBody PromocionesModel nuevaPromocion) {
        PromocionesModel promocionActualizada = promocionesService.actualizarPromocion(id, nuevaPromocion);
        return ResponseEntity.ok(promocionActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPromocion(@PathVariable Integer id) {
        promocionesService.eliminarPromocion(id);
        return ResponseEntity.noContent().build();
    }
}
