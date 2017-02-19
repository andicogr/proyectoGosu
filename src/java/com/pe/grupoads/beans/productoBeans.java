/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.beans;

import java.util.Date;

/**
 *
 * @author Raul
 */
public class productoBeans {
    private String codproducto;
    private String nombproducto;
    private String descripcion;
    private Double precioventa;
    private Date fechavencimiento;
    private Integer stock;
    private String unidad;
    private String receta;
    private String codcategoria;
    private String codmarca;

    public String getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(String codproducto) {
        this.codproducto = codproducto;
    }

    public String getNombproducto() {
        return nombproducto;
    }

    public void setNombproducto(String nombproducto) {
        this.nombproducto = nombproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Double precioventa) {
        this.precioventa = precioventa;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public String getCodcategoria() {
        return codcategoria;
    }

    public void setCodcategoria(String codcategoria) {
        this.codcategoria = codcategoria;
    }

    public String getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(String codmarca) {
        this.codmarca = codmarca;
    }
    
    public String getLabel(){
        return this.nombproducto;
    }
    
}
