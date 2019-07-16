package com.videoclub.videoclub.models.entities;


public class Distrito {
    
    private int id;
    private String distrito;
    
    public Distrito(){
        
    }
    public Distrito(int id,String distrito){
        this.id= id;
        this.distrito= distrito;
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
    
}
