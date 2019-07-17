package com.videoclub.videoclub.models.entities;


public class Provincia {
    
    private int id;
    private String provincia;
    
    public Provincia(){
        
    }

    public Provincia(int id, String provincia) {
        this.id = id;
        this.provincia = provincia;
    }
    
    
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}