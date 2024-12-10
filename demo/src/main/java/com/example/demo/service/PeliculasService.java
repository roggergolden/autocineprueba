package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.PeliculasModel;
import com.example.demo.repository.PeliculasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculasService {

    @Autowired
    private PeliculasRepository peliculasRepository;

    
    public Optional<PeliculasModel> buscarPorId(Integer id) {
        return peliculasRepository.findById(id);
    }

   
    public List<PeliculasModel> buscarPorTitulo(String titulo) {
        return peliculasRepository.findByTitulo(titulo);
    }

    
    public List<PeliculasModel> buscarPorDirector(String director) {
        return peliculasRepository.findByDirector(director);
    }

    
    public List<PeliculasModel> buscarTodas() {
        return peliculasRepository.findAll();
    }

    
    public PeliculasModel guardarPelicula(PeliculasModel pelicula) {
        return peliculasRepository.save(pelicula);
    }

    
    public void eliminarPelicula(Integer id) {
        peliculasRepository.deleteById(id);
    }
}