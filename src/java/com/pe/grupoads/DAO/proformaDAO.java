/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.DAO;

import com.mysql.jdbc.Statement;
import com.pe.grupoads.beans.clienteBeans;
import com.pe.grupoads.beans.detalleProformaBeans;
import com.pe.grupoads.beans.productoBeans;
import com.pe.grupoads.beans.proformaBeans;
import com.pe.grupoads.conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Raul Gosu
 */
public class proformaDAO {
    
    
    public static Integer insertarProforma(proformaBeans proforma, Integer codigoUsuarario){
        Connection cn = conexion.abrir();
        Integer idProforma = null;
        try {
            String sql = "insert into proforma(codcliente, fechaemisionproforma, importeproforma, codigousuario, estado) values(?,?,?,?,?)";
            PreparedStatement ps =  cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Integer codigoCliente = 0;
            if(proforma.getCliente()!= null && proforma.getCliente().getCodCliente() != null){
                codigoCliente = proforma.getCliente().getCodCliente();
            }
            ps.setInt(1, codigoCliente);
            java.sql.Date sqlDate = new java.sql.Date(proforma.getFechaEmision().getTime());
            ps.setDate(2, sqlDate);
            ps.setDouble(3, proforma.getInportePorforma());
            ps.setInt(4, codigoUsuarario);
            ps.setString(5, proforma.getEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                idProforma = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Error en insertarCliente " + ex);
        }
        return idProforma;
    }
    
    public static void insertarProformaDetalle(detalleProformaBeans detalle, Integer codigoProforma){
        Connection cn = conexion.abrir();
        try {
            PreparedStatement ps =  cn.prepareStatement("insert into detalleproforma(codproforma, codproducto, cantidadproforma, preciounitario, precioproforma) values(?,?,?,?,?)");

            ps.setInt(1, codigoProforma);
            ps.setInt(2, detalle.getCodProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecioUnitario());
            ps.setDouble(5, detalle.getPrecioTotal());
            

            ps.executeUpdate();
        
        } catch (SQLException ex) {
            System.out.println("Error en insertarCliente " + ex);
        }
    }
    
    public static ArrayList<proformaBeans> obtenerProformasPendientes(){
        ArrayList<proformaBeans> lista = new ArrayList<proformaBeans>();
        proformaBeans proforma = null;
        Connection cn;
        cn= conexion.abrir();
 
        try{
            String sql = "select p.codproforma, p.importeproforma, p.fechaemisionproforma from proforma p "
                    + "where  p.estado = 'emitido'";
            PreparedStatement  ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                proforma = new proformaBeans();

                
                proforma.setCodProforma(rs.getInt(1));
                proforma.setInportePorforma(rs.getDouble(2));
                proforma.setFechaEmision(rs.getDate(3));
                ArrayList<detalleProformaBeans> detalle = obtenerDetalleProformasPorId(rs.getInt(1));
                proforma.setDetalle(detalle);
                lista.add(proforma);
            }
            rs.close();
            cn.close();
        }
        catch (SQLException ex){
            System.out.println("Error en obtenerProformasPendientes " + ex);
        }
        return lista;
    }
    
    public static proformaBeans obtenerProformaPorId(Integer idProforma){
        proformaBeans proforma = null;
        Connection cn;
        cn= conexion.abrir();
 
        try{
            String sql = "select p.codproforma, p.importeproforma, p.fechaemisionproforma from proforma p "
                    + "where  p.codproforma = " + idProforma;
            PreparedStatement  ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                proforma = new proformaBeans();

                proforma.setCodProforma(rs.getInt(1));
                proforma.setInportePorforma(rs.getDouble(2));
                proforma.setFechaEmision(rs.getDate(3));
                ArrayList<detalleProformaBeans> detalle = obtenerDetalleProformasPorId(rs.getInt(1));
                proforma.setDetalle(detalle);
            }
            rs.close();
            cn.close();
        }
        catch (SQLException ex){
            System.out.println("Error en obtenerProformaPorId " + ex);
        }
        return proforma;
    }
    
    public static ArrayList<detalleProformaBeans> obtenerDetalleProformasPorId(Integer codProforma){
        ArrayList<detalleProformaBeans> lista = new ArrayList<detalleProformaBeans>();
        detalleProformaBeans detalle = null;
        Connection cn;
        cn= conexion.abrir();
 
        try{
            String sql = "select p.nombproducto, d.cantidadproforma, d.preciounitario, d.precioproforma, p.codproducto from detalleproforma d, productos p "
                    + "where p.codproducto = d.codproducto and d.codproforma = " + codProforma + "";
            PreparedStatement  ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                detalle = new detalleProformaBeans();
                
                detalle.setNombreProducto(rs.getString(1));
                detalle.setCantidad(rs.getInt(2));
                detalle.setPrecioUnitario(rs.getDouble(3));
                detalle.setPrecioTotal(rs.getDouble(4));
                detalle.setCodProducto(rs.getInt(5));

                lista.add(detalle);
            }
            rs.close();
            cn.close();
        }
        catch (SQLException ex){
            System.out.println("Error en obtenerProformasPendientes " + ex);
        }
        return lista;
    }
    
    public static void anularProforma(Integer idProforma){

        Connection cn = conexion.abrir();
        try {
            PreparedStatement ps =  cn.prepareStatement("update proforma set estado='anulado' where codproforma="+ idProforma +"");

             ps.executeUpdate();
  
        } catch (SQLException ex) {
           System.out.println("Error en anularProforma " + ex);
        }
    }
    
    public static void pagarProforma(Integer idProforma, Integer idCliente){

        Connection cn = conexion.abrir();
        try {
            String sql = "update proforma set estado='pagada' where codproforma="+ idProforma +"";
            if(idCliente != null){
                sql = "update proforma set estado='pagada', codcliente=" + idCliente + " where codproforma="+ idProforma +"";
            }
            PreparedStatement ps =  cn.prepareStatement(sql);

             ps.executeUpdate();
             actualizarStock(idProforma);
        } catch (SQLException ex) {
           System.out.println("Error en pagarProforma " + ex);
        }
    }
    
    public static void actualizarStock(Integer idProforma){
        Connection cn = conexion.abrir();
        ArrayList<detalleProformaBeans> detalle = obtenerDetalleProformasPorId(idProforma);
        
        try {
            for(detalleProformaBeans x: detalle){
                productoBeans producto = productoDAO.obtenerProductoPorId(x.getCodProducto());
                String sql = "update productos set stock = " + (producto.getStock() - x.getCantidad()) +" where codproducto = " + x.getCodProducto();
                PreparedStatement ps =  cn.prepareStatement(sql);
                
                 ps.executeUpdate();
            }

        } catch (SQLException ex) {
           System.out.println("Error en actualizarStock " + ex);
        }
    }
    
}
