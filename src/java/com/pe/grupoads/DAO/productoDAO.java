/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.DAO;

import com.pe.grupoads.beans.productoBeans;
import com.pe.grupoads.beans.usuarioBeans;
import com.pe.grupoads.conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class productoDAO {
    
    
    public static ArrayList<productoBeans> obtenerProductosPorNombre(String nombreProducto){
        ArrayList<productoBeans> listaProductos = new ArrayList<productoBeans>();
        
        productoBeans producto = null;
        Connection cn;
        cn= conexion.abrir();
 
        try{
            PreparedStatement  ps=cn.prepareStatement("select codproducto, nombproducto, receta, descripcion, precioventa, stock from  productos where nombproducto like '%" + nombreProducto + "%' ");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                producto = new productoBeans();
                producto.setCodproducto(rs.getString(1));
                producto.setNombproducto(rs.getString(2));
                producto.setReceta(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecioventa(rs.getDouble(5));
                producto.setStock(rs.getInt(6));

                listaProductos.add(producto);
                
            }
            rs.close();
            cn.close();
        }
        catch (SQLException ex){
            System.out.println("Error en obtenerProductosPorNombre "+ex);
        }
        return listaProductos;
    }
    
    public static ArrayList<productoBeans> obtenerProductosSimilares(Integer idProducto){
        ArrayList<productoBeans> listaProductos = new ArrayList<productoBeans>();
        
        productoBeans producto = null;
        Connection cn;
        cn= conexion.abrir();
        String sql = "SELECT codproducto, nombproducto, receta, descripcion, precioventa, stock " +
                     "FROM productos WHERE codproducto IN (" +
                        "SELECT DISTINCT(codproducto) FROM productocomponente WHERE codcomponente IN (" +
                            "SELECT codcomponente FROM productocomponente WHERE codproducto = " + idProducto + ")" +
                           ") AND codproducto !=" + idProducto;
        try{
            PreparedStatement  ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                producto = new productoBeans();
                producto.setCodproducto(rs.getString(1));
                producto.setNombproducto(rs.getString(2));
                producto.setReceta(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecioventa(rs.getDouble(5));
                producto.setStock(rs.getInt(6));

                listaProductos.add(producto);
                
            }
            rs.close();
            cn.close();
        }
        catch (SQLException ex){
            System.out.println("Error en obtenerProductosSimilares "+ex);
        }
        return listaProductos;
    }
    
    public static productoBeans obtenerProductoPorId(Integer idProducto){
        productoBeans producto = null;
        Connection cn;
        cn= conexion.abrir();
 
        try{
            PreparedStatement  ps=cn.prepareStatement("select codproducto, nombproducto, receta, descripcion, precioventa, stock from  productos where codproducto = " + idProducto);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                producto = new productoBeans();
                producto.setCodproducto(rs.getString(1));
                producto.setNombproducto(rs.getString(2));
                producto.setReceta(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecioventa(rs.getDouble(5));
                producto.setStock(rs.getInt(6));

            }
            rs.close();
            cn.close();
        }
        catch (SQLException ex){
            System.out.println("Error en obtenerProductosPorNombre "+ex);
        }
        return producto;
    }
}
