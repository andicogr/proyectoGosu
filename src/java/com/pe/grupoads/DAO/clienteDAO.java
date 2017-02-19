/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.DAO;

import com.mysql.jdbc.Statement;
import com.pe.grupoads.beans.clienteBeans;
import com.pe.grupoads.beans.productoBeans;
import com.pe.grupoads.beans.usuarioBeans;
import com.pe.grupoads.conexion.conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Raul Gosu
 */
public class clienteDAO {
 
    public static clienteBeans obtenerClientePorDni(String dniCliente){
        
        clienteBeans cliente = null;
        Connection cn;
        cn= conexion.abrir();
 
        try{
            PreparedStatement  ps=cn.prepareStatement("select codcliente, nombrecliente, dni from  cliente where dni like '" + dniCliente + "' ");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                cliente = new clienteBeans();
                cliente.setCodCliente(rs.getInt(1));
                cliente.setNombreCliente(rs.getString(2));
                cliente.setDni(rs.getString(3));

            }
            rs.close();
            cn.close();
        }
        catch (SQLException ex){
            System.out.println("Error en obtenerClientePorDni " + ex);
        }
        return cliente;
    }
    
    
    public static Integer insertarCliente(String dniCliente, String nombreCliente){
        Connection cn = conexion.abrir();
        Integer idCliente = null;
        try {
            PreparedStatement ps =  cn.prepareStatement("insert into cliente(dni,nombreCliente) values(?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, dniCliente);
            ps.setString(2, nombreCliente);

            ps.executeUpdate();
        
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                idCliente = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error en insertarCliente " + ex);
        }
        return idCliente;
    }
}