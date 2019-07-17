package com.videoclub.videoclub.models.entities;


public class Pelicula {
    
    private int id;
    private String titulo;
    private String descripcion;
    private String duracion;
    private String anio;
    private String imgUrl;
    private Lenguaje lenguaje;
    private Genero genero;

    public Pelicula(int id, String titulo, String descripcion, String duracion, String anio, String imgUrl, Lenguaje lenguaje, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.anio = anio;
        this.lenguaje = lenguaje;
        this.genero = genero;
    }

    public Pelicula() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getImgUrl(){
        return imgUrl;
    }
    
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

}     