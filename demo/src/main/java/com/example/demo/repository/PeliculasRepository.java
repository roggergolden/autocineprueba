package com.example.demo.repository;

import com.example.demo.model.PeliculasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculasRepository extends JpaRepository<PeliculasModel, Integer> {

    
    @Query("SELECT p FROM PeliculasModel p WHERE p.titulo = :titulo")
    List<PeliculasModel> findByTitulo(@Param("titulo") String titulo);

    
    @Query("SELECT p FROM PeliculasModel p WHERE p.director = :director")
    List<PeliculasModel> findByDirector(@Param("director") String director);
}