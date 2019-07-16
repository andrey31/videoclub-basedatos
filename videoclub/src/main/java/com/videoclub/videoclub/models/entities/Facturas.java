/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoclub.videoclub.models.entities;

import java.sql.Timestamp;

/**
 *
 * @author Maricela
 */
public class Facturas {
    
    private int id;
    private Timestamp fecha;
    private double monto;
    private String Facturas;

    public Facturas() {
    }

    
    public Facturas(int id, Timestamp fecha, double monto, String Facturas) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.Facturas= Facturas;
                
    }

    public String getFacturas() {
        return Facturas;
    }

    public void setFacturas(String Facturas) {
        this.Facturas = Facturas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
    
}
