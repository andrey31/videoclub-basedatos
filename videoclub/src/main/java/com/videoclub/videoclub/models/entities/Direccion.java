package com.videoclub.videoclub.models.entities;

public class Direccion {
    private int id;
    private String direccion;
    private Distrito distrito;

    public Direccion(int id, String direccion, Distrito distrito) {
        this.id = id;
        this.direccion = direccion;
        this.distrito = distrito;
    }

    public Direccion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    
    
    
    
}
