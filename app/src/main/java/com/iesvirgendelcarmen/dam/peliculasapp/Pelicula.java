package com.iesvirgendelcarmen.dam.peliculasapp;

/**
 * Created by matinal on 29/05/2018.
 */

public class Pelicula {
    private String nombre;
    private String director;
    private String genero;
    private String sinopsis;

    public Pelicula() {}

    public Pelicula(String nombre, String director, String genero, String sinopsis) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
