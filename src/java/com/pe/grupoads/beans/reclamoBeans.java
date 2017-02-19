/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.beans;

import java.sql.Date;

/**
 *
 * @author Raul
 */
public class reclamoBeans {
    private String codigoreclamo;
    private int codigousuario;
    private Date fechareclamo;
    private String asunto;
    private String descripcion;
    private String solucion;
    private String  codcliente;

    public String getCodigoreclamo() {
        return codigoreclamo;
    }

    public void setCodigoreclamo(String codigoreclamo) {
        this.codigoreclamo = codigoreclamo;
    }

    public int getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(int codigousuario) {
        this.codigousuario = codigousuario;
    }

    public Date getFechareclamo() {
        return fechareclamo;
    }

    public void setFechareclamo(Date fechareclamo) {
        this.fechareclamo = fechareclamo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }
    
    
}
