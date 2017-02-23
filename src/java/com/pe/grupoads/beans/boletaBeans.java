/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.beans;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Raul Gosu
 */
public class boletaBeans {
    private Integer codBoleta;
    private clienteBeans Cliente;
    private Date fechaEmision;
    private Double importe;
    private usuarioBeans Usuario;
    private List<detalleBoletaBeans> detalle;
    private String estado;

    public Integer getCodBoleta() {
        return codBoleta;
    }

    public void setCodBoleta(Integer codBoleta) {
        this.codBoleta = codBoleta;
    }

    public clienteBeans getCliente() {
        return Cliente;
    }

    public void setCliente(clienteBeans Cliente) {
        this.Cliente = Cliente;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public usuarioBeans getUsuario() {
        return Usuario;
    }

    public void setUsuario(usuarioBeans Usuario) {
        this.Usuario = Usuario;
    }

    public List<detalleBoletaBeans> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<detalleBoletaBeans> detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
