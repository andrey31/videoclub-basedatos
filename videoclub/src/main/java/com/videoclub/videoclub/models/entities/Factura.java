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
public class Factura {
    
    private int id;
    private Timestamp fecha;
    private double monto;

    public Factura() {
    }

    
    public Factura(int id, Timestamp fecha, double monto) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;         
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
