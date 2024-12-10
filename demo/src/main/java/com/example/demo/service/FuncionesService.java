package com.example.demo.service;
import com.example.demo.model.FuncionesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.FuncionesService;
import com.example.demo.repository.FuncionesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionesService {

    @Autowired
    private FuncionesRepository funcionesRepository;

    public List<FuncionesModel> obtenerFunciones() {
        return funcionesRepository.findAll();
    }

    public Optional<FuncionesModel> obtenerFuncionPorId(Integer id) {
        return funcionesRepository.findById(id);
    }

    public FuncionesModel guardarFuncion(FuncionesModel funcion) {
        return funcionesRepository.save(funcion);
    }

    public void eliminarFuncion(Integer id) {
        funcionesRepository.deleteById(id);
    }

    public FuncionesModel actualizarFuncion(Integer id, FuncionesModel nuevaFuncion) {
        return funcionesRepository.findById(id)
                .map(funcion -> {
                    funcion.setId_pelicula(nuevaFuncion.getId_pelicula());
                    funcion.setFecha_funcion(nuevaFuncion.getFecha_funcion());
                    funcion.setHora_inicio(nuevaFuncion.getHora_inicio());
                    funcion.setHora_fin(nuevaFuncion.getHora_fin());
                    funcion.setCapacidad_autos(nuevaFuncion.getCapacidad_autos());
                    funcion.setEstado_funcion(nuevaFuncion.getEstado_funcion());
                    funcion.setPrecio(nuevaFuncion.getPrecio());
                    return funcionesRepository.save(funcion);
                }).orElseGet(() -> {
                    nuevaFuncion.setId_funcion(id);
                    return funcionesRepository.save(nuevaFuncion);
                });
    }
}

