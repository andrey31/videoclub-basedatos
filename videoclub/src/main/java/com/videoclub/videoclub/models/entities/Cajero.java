package com.videoclub.videoclub.models.entities;


public class Cajero {

   
  private int id;
    private String cajero;


    public Cajero() {
    }

    public Cajero(int id, String cajero) {
        this.id = id;
        this.cajero = cajero;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCajero() {
        return this.cajero;
    }
    
}

