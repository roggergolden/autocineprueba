package com.example.demo.repository;

import com.example.demo.model.PedidosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<PedidosModel, Integer> {
}
