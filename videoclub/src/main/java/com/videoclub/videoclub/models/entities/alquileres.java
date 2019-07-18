package com.videoclub.videoclub.models.entities;

/**
 * Cantones
 */
public class alquileres {

    private int id;
    private String fecha_alquiler;
    private String fecha_entrega;
    private Boolean estado;
    private Cliente cliente;
    private Cajero cajero;
    private Factura factura;


    public alquileres() {
    }

    public alquileres(int id, String fecha_alquiler, String fecha_entrega, Boolean estado, Cliente cliente, Cajero cajero, Factura factura) {
        this.id = id;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_entrega = fecha_entrega;
        this.estado = estado;
        this.cliente = cliente;
        this.cajero = cajero;
        this.factura = factura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(String fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    
}