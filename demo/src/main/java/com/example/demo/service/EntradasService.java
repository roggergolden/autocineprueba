package com.example.demo.service;

import com.example.demo.model.EntradasModel;
import com.example.demo.repository.EntradasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradasService {

    @Autowired
    private EntradasRepository entradasRepository;

    public List<EntradasModel> obtenerEntradas() {
        return entradasRepository.findAll();
    }

    public Optional<EntradasModel> obtenerEntradaPorId(Integer id) {
        return entradasRepository.findById(id);
    }

    public EntradasModel guardarEntrada(EntradasModel entrada) {
        return entradasRepository.save(entrada);
    }

    public void eliminarEntrada(Integer id) {
        entradasRepository.deleteById(id);
    }

    public EntradasModel actualizarEntrada(Integer id, EntradasModel nuevaEntrada) {
        return entradasRepository.findById(id)
                .map(entrada -> {
                    entrada.setId_usuario(nuevaEntrada.getId_usuario());
                    entrada.setId_funcion(nuevaEntrada.getId_funcion());
                    entrada.setMonto_pagado(nuevaEntrada.getMonto_pagado());
                    entrada.setMetodo_pago(nuevaEntrada.getMetodo_pago());
                    entrada.setFecha_compra(nuevaEntrada.getFecha_compra());
                    entrada.setEstado_pago(nuevaEntrada.getEstado_pago());
                    return entradasRepository.save(entrada);
                }).orElseGet(() -> {
                    nuevaEntrada.setId_entrada(id);
                    return entradasRepository.save(nuevaEntrada);
                });
    }
}
