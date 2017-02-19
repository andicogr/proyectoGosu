
package com.pe.grupoads.DAO;

import com.pe.grupoads.beans.privilegioBeans;
import com.pe.grupoads.conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class privilegioDAO {
    public static ArrayList<privilegioBeans> listarPrivilegioxUsuario(int ID_usuario)
    {
        conexion.ConexionPrepare();
        ArrayList<privilegioBeans> lista = new ArrayList<privilegioBeans>();
        try {
            String sql = "select p.codigoprivilegio, p.nombreprivilegio from privilegios p,  detalleprivilegio dp where dp.codigoprivilegio = p.codigoprivilegio and dp.codigousuario =" + ID_usuario;
            PreparedStatement ps = conexion.ConexionPrepare().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            privilegioBeans pri=null;
            while(rs.next())
            {
                pri = new privilegioBeans();
                pri.setCODIGOPRIVILEGIO(rs.getString(1));
                pri.setNOMBREPRIVILEGIO(rs.getString(2));
                lista.add(pri);
            }
            conexion.ConexionPrepare().close();
            rs.close();
            ps.close();
        } catch (Exception ex) {
            System.out.println("Error al listar privilegios por usuario "+ex);
        }
        return lista;
    }
    
}
