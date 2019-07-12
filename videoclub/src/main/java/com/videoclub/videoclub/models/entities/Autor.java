package com.videoclub.videoclub.models.entities;

/**
 * Autor
 */
public class Autor {

    private int id;
    private String autor;


    public Autor() {
    }

    public Autor(int id, String autor) {
        this.id = id;
        this.autor = autor;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return this.autor;
    }
}