/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.DAO;

import static com.pe.grupoads.DAO.proformaDAO.obtenerDetalleProformasPorId;
import com.pe.grupoads.beans.detalleProformaBeans;
import com.pe.grupoads.beans.productoBeans;
import com.pe.grupoads.beans.usuarioBeans;
import com.pe.grupoads.conexion.conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
   
    public static void actualizarStockProducto(Integer idProducto ,Integer CantidadAgregar){
        Connection cn = conexion.abrir();
        
        try {
            productoBeans producto = obtenerProductoPorId(idProducto);
            String sql = "update productos set stock = " + (producto.getStock() + CantidadAgregar) +" where codproducto = " + idProducto;
            PreparedStatement ps =  cn.prepareStatement(sql);

             ps.executeUpdate();

        } catch (SQLException ex) {
           System.out.println("Error en ProductoDAO.actualizarStock " + ex);
        }
    }
    
    public static ArrayList<productoBeans> listar()
    {
        conexion.ConexionPrepare();
        ArrayList<productoBeans>  lista= new ArrayList<productoBeans>();
        productoBeans pro ;
            try {
                PreparedStatement ps = conexion.ConexionPrepare().prepareStatement("select codproducto,nombproducto,stock from productos");
                ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
               pro = new productoBeans();
               pro.setCodproducto(rs.getString(1));
               pro.setNombproducto(rs.getString(2));
               pro.setStock(rs.getInt(3));
               
               
               lista.add(pro);
            }
            rs.close();
            ps.close();
            conexion.ConexionPrepare().close();
            } catch (Exception ex) {
                System.out.println("Error al listar Productos "+ex);
            }
            return lista;
    }
    
    public static Integer insertarProducto(productoBeans producto){
        Connection cn = conexion.abrir();
        Integer idProducto = null;
        try {
            String sql = "insert into productos(nombproducto,descripcion,precioventa,stock,receta) values(?,?,?,?,?)";
            PreparedStatement ps =  cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombproducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioventa());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getReceta());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                idProducto = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Error en insertarProducto " + ex);
        }
        return idProducto;
    }
    
    public static void insertarComponenetesPorProducto(Integer idComponente, Integer idProducto){
        Connection cn = conexion.abrir();
        try {
            String sql = "insert into productocomponente(codproducto,codcomponente) values(?,?)";

            PreparedStatement ps =  cn.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ps.setInt(2, idComponente);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en insertarComponenetesPorProducto " + ex);
        }
    }
}
