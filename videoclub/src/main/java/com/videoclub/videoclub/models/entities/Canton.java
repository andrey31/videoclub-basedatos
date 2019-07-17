package com.videoclub.videoclub.models.entities;

/**
 * Cantones
 */
public class Canton {

    private int id;
    private String canton;
    private Provincia provincia;


    public Canton() {
    }

    public Canton(int id, String canton, Provincia provincia) {
        this.id = id;
        this.canton = canton;
        this.provincia = provincia;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCanton() {
        return this.canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public Provincia getProvincia() {
        return this.provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}