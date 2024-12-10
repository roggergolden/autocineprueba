package com.example.demo.repository;
import com.example.demo.model.FuncionesModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionesRepository extends JpaRepository<FuncionesModel, Integer> {
    
}

