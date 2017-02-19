
package com.pe.grupoads.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion 
{
    public static Connection abrir()
    {
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn= DriverManager.getConnection("jdbc:mysql://localhost/farmacia_farmalave", "root", "perugano");
        } catch (Exception ex) {
           System.out.println("Error en la conexion a la base de datos "+ ex);
        }
        return cn;
    }
    public static Connection ConexionPrepare()
    {
        Connection cn =conexion.abrir();
        return cn;
    }
}