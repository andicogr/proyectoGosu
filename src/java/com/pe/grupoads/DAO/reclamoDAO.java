/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.DAO;

import com.pe.grupoads.beans.reclamoBeans;
import com.pe.grupoads.beans.usuarioBeans;
import com.pe.grupoads.conexion.conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raul
 */
public class reclamoDAO {
    public static String registrarReclamo(reclamoBeans recl)
    {
        String mensaje=null;
        Connection cn = conexion.abrir();
        try {
            PreparedStatement ps =  cn.prepareStatement("insert into reclamocliente(codigousuario,fechareclamo,asunto,descripcion,solucion,codcliente, codigoproforma) values(?,?,?,?,?,?,?)");

           ps.setInt(1,recl.getCodigousuario());
           java.sql.Date sqlDate = new java.sql.Date(recl.getFechareclamo().getTime());
           ps.setDate(2,sqlDate);
           ps.setString(3,recl.getAsunto());
           ps.setString(4,recl.getDescripcion());
           ps.setString(5,recl.getSolucion());
           ps.setInt(6,recl.getCodcliente());
           ps.setInt(7, recl.getCodigoProforma());
           
           ps.executeUpdate();
             mensaje="Se Registro Reclamo";
        
        } catch (SQLException ex) {
           mensaje=ex.getMessage();
        }
        return mensaje;
    }
}
