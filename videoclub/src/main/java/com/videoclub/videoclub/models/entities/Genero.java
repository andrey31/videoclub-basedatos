/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoclub.videoclub.models.entities;

/**
 *
 * @author andre
 */
public class Genero {
        private int id;
    private String genero;


    public Genero() {
    }

    public Genero(int id, String Genero) {
        this.id = id;
        this.genero = genero;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
}
