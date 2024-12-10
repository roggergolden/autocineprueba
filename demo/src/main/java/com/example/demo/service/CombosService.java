package com.example.demo.service;

import com.example.demo.model.CombosModel;
import com.example.demo.repository.CombosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombosService {

    @Autowired
    private CombosRepository combosRepository;

    public List<CombosModel> obtenerCombos() {
        return combosRepository.findAll();
    }

    public Optional<CombosModel> obtenerComboPorId(Integer id) {
        return combosRepository.findById(id);
    }

    public CombosModel guardarCombo(CombosModel combo) {
        return combosRepository.save(combo);
    }

    public void eliminarCombo(Integer id) {
        combosRepository.deleteById(id);
    }

    public CombosModel actualizarCombo(Integer id, CombosModel nuevoCombo) {
        return combosRepository.findById(id)
                .map(combo -> {
                    combo.setNombre_combo(nuevoCombo.getNombre_combo());
                    combo.setDescripcion_combo(nuevoCombo.getDescripcion_combo());
                    combo.setPrecio_combo(nuevoCombo.getPrecio_combo());
                    combo.setFecha_inicio(nuevoCombo.getFecha_inicio());
                    combo.setFecha_fin(nuevoCombo.getFecha_fin());
                    combo.setEstado(nuevoCombo.getEstado());
                    return combosRepository.save(combo);
                }).orElseGet(() -> {
                    nuevoCombo.setId_combo(id);
                    return combosRepository.save(nuevoCombo);
                });
    }
}
