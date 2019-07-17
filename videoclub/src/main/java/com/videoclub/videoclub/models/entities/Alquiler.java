package com.videoclub.videoclub.models.entities;

import java.security.Timestamp;

/**
 * Alquiler
 */
public class Alquiler {

    private int id;
    private Timestamp fechaAlquiler;
    private Timestamp fechaEntrega;
    private boolean estado;
    private Cliente cliente;
    private Cajero cajero;
    private Factura factura;


    public Alquiler() {
    }

    public Alquiler(int id, Timestamp fechaAlquiler, Timestamp fechaEntrega, boolean estado, Cliente cliente, Cajero cajero, Factura factura) {
        this.id = id;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.cliente = cliente;
        this.cajero = cajero;
        this.factura = factura;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFechaAlquiler() {
        return this.fechaAlquiler;
    }

    public void setFechaAlquiler(Timestamp fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Timestamp getFechaEntrega() {
        return this.fechaEntrega;
    }

    public void setFechaEntrega(Timestamp fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cajero getCajero() {
        return this.cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}