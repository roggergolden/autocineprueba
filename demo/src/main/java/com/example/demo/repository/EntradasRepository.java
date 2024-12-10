package com.example.demo.repository;

import com.example.demo.model.EntradasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradasRepository extends JpaRepository<EntradasModel, Integer> {
}
