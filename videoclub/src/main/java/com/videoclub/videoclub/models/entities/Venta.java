package com.videoclub.videoclub.models.entities;

import java.sql.Timestamp;

/**
 * Venta
 */
public class Venta {

    private int id;
    private Timestamp fechaVenta;
    private Cliente cliente;
    private Cajero cajero;
    private Factura factura;


    public Venta() {
    }

    public Venta(int id, Timestamp fechaVenta, Cliente cliente, Cajero cajero, Factura factura) {
        this.id = id;
        this.fechaVenta = fechaVenta;
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

    public Timestamp getFechaVenta() {
        return this.fechaVenta;
    }

    public void setFechaVenta(Timestamp fechaVenta) {
        this.fechaVenta = fechaVenta;
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