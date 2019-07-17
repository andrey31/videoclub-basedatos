package com.videoclub.videoclub.models.entities;

public class Cliente {

   
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private String tel;
    private Direccion direccion;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido1, String apellido2,String correo, String tel, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.tel = tel;
        this.direccion = direccion;
    }

    public int getId() {
        return this.id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTel() {
        return tel;
    }

    public Direccion getDireccion(){
        return this.direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public void setDireccion(Direccion direccion){
        this.direccion = direccion;
    }
}