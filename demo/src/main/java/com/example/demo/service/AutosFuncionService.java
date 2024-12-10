package com.example.demo.service;

import com.example.demo.model.AutosFuncionModel;
import com.example.demo.repository.AutosFuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutosFuncionService {

    @Autowired
    private AutosFuncionRepository autosFuncionRepository;

    public List<AutosFuncionModel> obtenerAutosFuncion() {
        return autosFuncionRepository.findAll();
    }

    public Optional<AutosFuncionModel> obtenerAutoFuncionPorId(Integer id) {
        return autosFuncionRepository.findById(id);
    }

    public AutosFuncionModel guardarAutoFuncion(AutosFuncionModel autoFuncion) {
        return autosFuncionRepository.save(autoFuncion);
    }

    public void eliminarAutoFuncion(Integer id) {
        autosFuncionRepository.deleteById(id);
    }

    public AutosFuncionModel actualizarAutoFuncion(Integer id, AutosFuncionModel nuevoAutoFuncion) {
        return autosFuncionRepository.findById(id)
                .map(autoFuncion -> {
                    autoFuncion.setId_funcion(nuevoAutoFuncion.getId_funcion());
                    autoFuncion.setId_usuario(nuevoAutoFuncion.getId_usuario());
                    autoFuncion.setPlaca_auto(nuevoAutoFuncion.getPlaca_auto());
                    autoFuncion.setHora_entrada(nuevoAutoFuncion.getHora_entrada());
                    autoFuncion.setUbicacion_auto(nuevoAutoFuncion.getUbicacion_auto());
                    return autosFuncionRepository.save(autoFuncion);
                }).orElseGet(() -> {
                    nuevoAutoFuncion.setId_auto_funcion(id);
                    return autosFuncionRepository.save(nuevoAutoFuncion);
                });
    }
}
