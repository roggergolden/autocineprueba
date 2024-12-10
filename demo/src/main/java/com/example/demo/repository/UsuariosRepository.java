package com.example.demo.repository;

import com.example.demo.model.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosModel, Integer> {

    
    @Query("SELECT u FROM UsuariosModel u WHERE u.email = :email")
    Optional<UsuariosModel> findByEmail(@Param("email") String email);

   
}