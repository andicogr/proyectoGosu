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
public class proformaBeans {
    private Integer codProforma;
    private clienteBeans Cliente;
    private Date fechaEmision;
    private Double inportePorforma;
    private usuarioBeans Usuario;
    private List<detalleProformaBeans> detalle;
    private String estado;

    public Integer getCodProforma() {
        return codProforma;
    }

    public void setCodProforma(Integer codProforma) {
        this.codProforma = codProforma;
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

    public Double getInportePorforma() {
        return inportePorforma;
    }

    public void setInportePorforma(Double inportePorforma) {
        this.inportePorforma = inportePorforma;
    }

    public usuarioBeans getUsuario() {
        return Usuario;
    }

    public void setUsuario(usuarioBeans Usuario) {
        this.Usuario = Usuario;
    }

    public List<detalleProformaBeans> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<detalleProformaBeans> detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
