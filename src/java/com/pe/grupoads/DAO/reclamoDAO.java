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
            PreparedStatement ps =  cn.prepareStatement("insert into usuario(codigoreclamo,codigousuario,fechareclamo,asunto,descripcion,solucion,codcliente) values(?,?,?,?,?,?,?)");
           
           
           ps.setString(1,recl.getCodigoreclamo());
           ps.setInt(2,recl.getCodigousuario());
           ps.setDate(3,recl.getFechareclamo());
           ps.setString(4,recl.getAsunto());
           ps.setString(5,recl.getDescripcion());
           ps.setString(6,recl.getSolucion());
           ps.setString(7,recl.getCodcliente());
           
           ps.executeUpdate();
             mensaje="Se Registro Reclamo";
        
        } catch (SQLException ex) {
           mensaje=ex.getMessage();
        }
        return mensaje;
    }
}
