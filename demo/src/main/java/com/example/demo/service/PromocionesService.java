package com.example.demo.service;

import com.example.demo.model.PromocionesModel;
import com.example.demo.repository.PromocionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionesService {

    @Autowired
    private PromocionesRepository promocionesRepository;

    public List<PromocionesModel> obtenerPromociones() {
        return promocionesRepository.findAll();
    }

    public Optional<PromocionesModel> obtenerPromocionPorId(Integer id) {
        return promocionesRepository.findById(id);
    }

    public PromocionesModel guardarPromocion(PromocionesModel promocion) {
        return promocionesRepository.save(promocion);
    }

    public void eliminarPromocion(Integer id) {
        promocionesRepository.deleteById(id);
    }

    public PromocionesModel actualizarPromocion(Integer id, PromocionesModel nuevaPromocion) {
        return promocionesRepository.findById(id)
                .map(promocion -> {
                    promocion.setDescripcion_promocion(nuevaPromocion.getDescripcion_promocion());
                    promocion.setPorcentaje_descuento(nuevaPromocion.getPorcentaje_descuento());
                    promocion.setId_producto(nuevaPromocion.getId_producto());
                    promocion.setId_combo(nuevaPromocion.getId_combo());
                    promocion.setFecha_inicio(nuevaPromocion.getFecha_inicio());
                    promocion.setFecha_fin(nuevaPromocion.getFecha_fin());
                    promocion.setEstado(nuevaPromocion.getEstado());
                    return promocionesRepository.save(promocion);
                }).orElseGet(() -> {
                    nuevaPromocion.setId_promocion(id);
                    return promocionesRepository.save(nuevaPromocion);
                });
    }
}
