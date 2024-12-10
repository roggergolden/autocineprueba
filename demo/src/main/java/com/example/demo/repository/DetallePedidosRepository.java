package com.example.demo.repository;

import com.example.demo.model.DetallePedidosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidosRepository extends JpaRepository<DetallePedidosModel, Integer> {
}
