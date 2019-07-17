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
public class Lenguaje {
      private int id;
    private String lenguaje;


    public Lenguaje() {
    }

    public Lenguaje(int id, String lenguaje) {
        this.id = id;
        this.lenguaje = lenguaje;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLenguaje() {
        return this.lenguaje;
    }
    public void setLenguaje (String lenguaje) {
        this.lenguaje = lenguaje;
    }
}
