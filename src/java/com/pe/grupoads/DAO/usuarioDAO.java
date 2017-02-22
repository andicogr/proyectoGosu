
package com.pe.grupoads.DAO;

import com.pe.grupoads.beans.usuarioBeans;
import com.pe.grupoads.conexion.conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class usuarioDAO {
   
    
        public static int ValidarUsuario(String usuario,String clave)
    {
        conexion.ConexionPrepare();
        int idUsuario= 0;
        String Estado= "Activo";
        try {
            PreparedStatement ps = conexion.ConexionPrepare().prepareStatement("select codigousuario,estado  from usuario  where idlogin='"+usuario+"' and idpassword='"+clave+"'");
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
               idUsuario = rs.getInt(1);
               Estado= rs.getString(2);
                
            }
            conexion.ConexionPrepare().close();
            rs.close();
            ps.close();
        } catch (Exception ex) {
            System.out.println("no existe el usuario "+ex);
        }
        if (Estado.equals("Inactivo"))
        {
            idUsuario=-1;
        }
        return idUsuario;
    }
   public static usuarioBeans ObtenerUsuarioxID(int ID)
    {
        usuarioBeans user=null;
        Connection cn;
        String query="select *from  usuario where codigousuario=" + ID ;
        
        cn= conexion.abrir();
        ResultSet rs;
        try
        {
            Statement  st=cn.createStatement();
            rs=st.executeQuery(query);
            
            if(rs.next())
            {
                user=new usuarioBeans();
                user.setCODIGOUSUARIO(rs.getInt(1));
                user.setIDLOGIN(rs.getString(2));
                user.setIDPASSWORD(rs.getString(3));
                user.setESTADO(rs.getString(4));
               
                
                
            }
            rs.close();
            st.close();
            cn.close();
        }
        catch (SQLException ex) 
        {
            System.out.println(" ERROR AL OBTENER USUARIO");
        }
        return user;
    }
    public static String insertarUsuario(usuarioBeans usu)
    {
        String msg=null;
        Connection cn = conexion.abrir();
        try {
            PreparedStatement ps =  cn.prepareStatement("insert into usuario(idlogin,idpassword,estado,dni,nombre,apellidopaterno,apellidomaterno,direccion,email,celular,fijo) values(?,?,?,?,?,?,?,?,?,?,?)");
           
           
           ps.setString(1,usu.getIDLOGIN());
           ps.setString(2,usu.getIDPASSWORD());
           ps.setString(3,usu.getESTADO());
           ps.setInt(4,usu.getDNI());
           ps.setString(5,usu.getNOMBRE());
           ps.setString(6,usu.getAPELLIDOPATERNO());
           ps.setString(7,usu.getAPELLIDOMATERNO());
           ps.setString(8,usu.getDIRECCION());
           ps.setString(9,usu.getEMAIL());
           ps.setInt(10,usu.getCELULAR());
           ps.setInt(11,usu.getFIJO());
           //ps.setDate(12,(Date)usu.getFECHAINGRESO());
             
           ps.executeUpdate();
             msg="se insertó usuario";
        
        } catch (SQLException ex) {
           msg=ex.getMessage();
        }
        return msg;
    }
     public static ArrayList<usuarioBeans> Listar()
    {
        ArrayList<usuarioBeans> lista= new ArrayList<usuarioBeans>();
        
      usuarioBeans user=null;
        Connection cn;
      
        cn= conexion.abrir();
       
        try
        {
            PreparedStatement  ps=cn.prepareStatement("select codigousuario,idlogin,idpassword,estado,dni,nombre,apellidopaterno,apellidomaterno,direccion,email,celular,fijo,fechaingreso from  usuario");
             ResultSet rs=ps.executeQuery();
             while(rs.next())
            {
                user=new usuarioBeans();
                user.setCODIGOUSUARIO(rs.getInt(1));
                user.setIDLOGIN(rs.getString(2));
                user.setIDPASSWORD(rs.getString(3));
                user.setESTADO(rs.getString(4));
                user.setDNI(rs.getInt(5));
                user.setNOMBRE(rs.getString(6));
                user.setAPELLIDOPATERNO(rs.getString(7));
                user.setAPELLIDOMATERNO(rs.getString(8));
                user.setDIRECCION(rs.getString(9));
                user.setEMAIL(rs.getString(10));
                user.setCELULAR(rs.getInt(11));
                user.setFIJO(rs.getInt(12));
                try {
                    user.setFECHAINGRESO(rs.getDate(13));
                    
                } catch (Exception e) {
                    user.setFECHAINGRESO(null);
                    System.out.println("mal formato para la fecha de ingreso");
                }
                
                lista.add(user);
                
            }
            rs.close();
         
            cn.close();
        }
        catch (SQLException ex) 
        {
            System.out.println("Error en listar usuario "+ex);
        }
        return lista;
    }
     public static String editarUsuario(usuarioBeans usu)
    {
        String msg=null;
        Connection cn = conexion.abrir();
        try {
            PreparedStatement ps =  cn.prepareStatement("update usuario set codigousuario=?, dni=?,idlogin=?,idpassword=?,estado=?,nombre=?,apellidopaterno=?,apellidomaterno=?,direccion=?,email=?,celular=?,fijo=? where codigousuario='"+usu.getCODIGOUSUARIO()+"'");
           ps.setInt(1,usu.getCODIGOUSUARIO());
           ps.setInt(2, usu.getDNI());
           ps.setString(3, usu.getIDLOGIN());
           ps.setString(4, usu.getIDPASSWORD());
           ps.setString(5, usu.getESTADO());
           ps.setString(6, usu.getNOMBRE());
           ps.setString(7, usu.getAPELLIDOPATERNO());
           ps.setString(8, usu.getAPELLIDOMATERNO());
           ps.setString(9, usu.getDIRECCION());
           ps.setString(10, usu.getEMAIL());
           ps.setInt(11,usu.getCELULAR());
           ps.setInt(12, usu.getFIJO());
           //ps.setDate(13, usu.getFECHAINGRESO());
             ps.executeUpdate();
             msg="Se Edito Usuario Correctamente";
        
        } catch (SQLException ex) {
           msg=ex.getMessage();
        }
        return msg;
    }
      public static usuarioBeans ListarPorId(int id)
    {
      
        usuarioBeans user=null;
        Connection cn= conexion.abrir();
       
        try
        {
            PreparedStatement  ps=cn.prepareStatement("select codigousuario, dni, idlogin, idpassword,estado, nombre, apellidopaterno, apellidomaterno, direccion, email, celular, fijo, fechaingreso from  usuario where codigousuario="+id+" ");
             ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                user=new usuarioBeans();
                user.setCODIGOUSUARIO(rs.getInt(1));
                user.setDNI(rs.getInt(2));
                user.setIDLOGIN(rs.getString(3));
                user.setIDPASSWORD(rs.getString(4));
                user.setESTADO(rs.getString(5));
                user.setNOMBRE(rs.getString(6));
                user.setAPELLIDOPATERNO(rs.getString(7));
                user.setAPELLIDOMATERNO(rs.getString(8));
                user.setDIRECCION(rs.getString(9));
                user.setEMAIL(rs.getString(10));
                user.setCELULAR(rs.getInt(11));
                user.setFIJO(rs.getInt(12));
                user.setFECHAINGRESO(rs.getDate(13));
                
                
            }
            rs.close();
          
            cn.close();
        }
        catch (SQLException ex) 
        {
            System.out.println("Error en validar usuario "+ex);
        }
        return user;
    }
}
