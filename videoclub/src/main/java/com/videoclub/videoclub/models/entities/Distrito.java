package com.videoclub.videoclub.models.entities;


public class Distrito {
    
    private int id;
    private String distrito;
    private Canton canton;

    public Distrito(){
        
    }
    public Distrito(int id, String distrito, Canton canton){
        this.id = id;
        this.distrito = distrito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Canton getCanton() {
        return this.canton;
    }

    public void setCanton(Canton canton){
        this.canton = canton;
    }
}
