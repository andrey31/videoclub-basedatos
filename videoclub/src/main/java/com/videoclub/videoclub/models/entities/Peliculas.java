package com.videoclub.videoclub.models.entities;


public class Peliculas {
    
    private int id;
    private String peliculas;
    
    public Peliculas(){
        
    }
    public Peliculas(int id,String peliculas){
        this.id= id;
        this.peliculas= peliculas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(String peliculas) {
        this.peliculas = peliculas;
    }
    
}
