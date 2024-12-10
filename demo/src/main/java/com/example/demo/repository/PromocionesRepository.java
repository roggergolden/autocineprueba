package com.example.demo.repository;

import com.example.demo.model.PromocionesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionesRepository extends JpaRepository<PromocionesModel, Integer> {
}
