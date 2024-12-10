package com.example.demo.repository;

import com.example.demo.model.CombosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombosRepository extends JpaRepository<CombosModel, Integer> {
}
