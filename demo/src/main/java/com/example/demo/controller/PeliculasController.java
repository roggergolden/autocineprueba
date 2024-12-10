package com.example.demo.controller;

import com.example.demo.model.PeliculasModel;
import com.example.demo.service.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "http://localhost:3000") 
public class PeliculasController {

    @Autowired
    private PeliculasService peliculasService;

    
    @GetMapping("/obtener")
    public ResponseEntity<?> obtenerPeliculas(@RequestParam(value = "titulo", required = false) String titulo) {
        try {
            List<PeliculasModel> peliculas;
            if (titulo != null && !titulo.isEmpty()) {
                peliculas = peliculasService.buscarPorTitulo(titulo);
            } else {
                peliculas = peliculasService.buscarTodas();
            }
            return ResponseEntity.ok(peliculas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las películas: " + e.getMessage());
        }
    }

    
    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerPeliculaPorId(@PathVariable Integer id) {
        try {
            Optional<PeliculasModel> pelicula = peliculasService.buscarPorId(id);
            if (pelicula.isPresent()) {
                return ResponseEntity.ok(pelicula.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Película no encontrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener la película: " + e.getMessage());
        }
    }

    
    @PostMapping("/insertar")
    public ResponseEntity<?> insertarPelicula(@RequestBody PeliculasModel peliculaModel) {
        try {
            PeliculasModel guardado = peliculasService.guardarPelicula(peliculaModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar la película: " + e.getMessage());
        }
    }

    
    @PutMapping("/modificar")
    public ResponseEntity<?> modificarPelicula(@RequestBody PeliculasModel peliculaModel) {
        try {
            Optional<PeliculasModel> peliculaExistente = peliculasService.buscarPorId(peliculaModel.getId_pelicula());
            if (peliculaExistente.isPresent()) {
                PeliculasModel modificado = peliculasService.guardarPelicula(peliculaModel);
                return ResponseEntity.ok(modificado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Película no encontrada para modificar");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar la película: " + e.getMessage());
        }
    }

   
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPelicula(@PathVariable Integer id) {
        try {
            Optional<PeliculasModel> peliculaExistente = peliculasService.buscarPorId(id);
            if (peliculaExistente.isPresent()) {
                peliculasService.eliminarPelicula(id);
                return ResponseEntity.ok().body("Película eliminada con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Película no encontrada para eliminar");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la película: " + e.getMessage());
        }
    }
}
