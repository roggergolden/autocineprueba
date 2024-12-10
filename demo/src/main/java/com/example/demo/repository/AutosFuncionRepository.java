package com.example.demo.repository;

import com.example.demo.model.AutosFuncionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutosFuncionRepository extends JpaRepository<AutosFuncionModel, Integer> {
}
