package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;


@Table(name = "peliculas")
public class PeliculasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pelicula;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;  

    @Column(name = "sinopsis", nullable = false, columnDefinition = "TEXT")
    private String sinopsis;

    @Column(name = "poster_url", length = 255)
    private String poster_url;

    @Column(name = "fecha_estreno", nullable = false)
    private LocalDate fecha_estreno;

    @Column(name = "director", length = 100)
    private String director;

    // Getters y Setters

    public Integer getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Integer id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public LocalDate getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(LocalDate fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
