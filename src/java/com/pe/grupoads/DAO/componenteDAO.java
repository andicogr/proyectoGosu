/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.DAO;

import com.pe.grupoads.beans.componenteBeans;
import com.pe.grupoads.beans.productoBeans;
import com.pe.grupoads.conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class componenteDAO {
    
    public static ArrayList<componenteBeans> obtenerComponentesPorNombre(String nombre){
        ArrayList<componenteBeans> listaComponentes = new ArrayList<componenteBeans>();
        
        componenteBeans componente = null;
        Connection cn;
        cn= conexion.abrir();
 
        try{
            PreparedStatement  ps=cn.prepareStatement("select codcomponente, nombrecomponente, concentracion, unidad from componentes where nombrecomponente like '%" + nombre + "%' ");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                componente = new componenteBeans();
                componente.setCodComponente(rs.getInt(1));
                componente.setConcentracion(rs.getString(3));
                componente.setNombre(rs.getString(2));
                componente.setUnidad(rs.getString(4));


                listaComponentes.add(componente);
                
            }
            rs.close();
            cn.close();
        }
        catch (SQLException ex){
            System.out.println("Error en obtenerComponentesPorNombre "+ex);
        }
        return listaComponentes;
    }

}
