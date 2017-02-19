
package com.pe.grupoads.controlador;

import com.pe.grupoads.DAO.privilegioDAO;
import com.pe.grupoads.DAO.usuarioDAO;
import com.pe.grupoads.beans.privilegioBeans;
import com.pe.grupoads.beans.usuarioBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raul
 */
@WebServlet(name = "servletLogin", urlPatterns = {"/servletLogin","/logearUsuario", "/registrarProducto", "/cerrarSession"})
public class servletLogin extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
      String path=request.getServletPath();
        Integer IDUser = (Integer)request.getSession().getAttribute("IDusuario");
        if(IDUser==null && !path.equals("/logearUsuario")){
            response.sendRedirect("sesionExpirada.jsp");
        }else{
            

      if(path.equals("/logearUsuario"))
      {
          int idusuario = -100;
          String usuario=request.getParameter("txtusuario");
          String password=request.getParameter("txtpassword");
          if(usuario.length()<=3 || usuario.equals("")){
              idusuario = -2;
          }
          if(password.length()<=3 || password.equals("")){
              idusuario = -2;
          }
          
          if(idusuario != -2){
            idusuario = usuarioDAO.ValidarUsuario(usuario, password);
            if(idusuario==0)
            {
                String msg="Password y/o Usuaro Incorrectos ";
                request.getSession().removeAttribute("mensaje");
                request.getSession().setAttribute("mensaje", msg);
                response.sendRedirect("login.jsp");

            }
            else if(idusuario==-1)
                {
                   String msg="El usuario se encuentra en Estado inactivo ";
                request.getSession().removeAttribute("mensaje");
                request.getSession().setAttribute("mensaje", msg);
                response.sendRedirect("login.jsp"); 
                }
            else{
                usuarioBeans user = usuarioDAO.ObtenerUsuarioxID(idusuario);
                ArrayList<privilegioBeans> privilegios = privilegioDAO.listarPrivilegioxUsuario(idusuario);
                String privi = "NoTiene";
                if(privilegios.size() > 0){
                    privi = privilegios.get(0).getNOMBREPRIVILEGIO();
                }
                request.getSession().removeAttribute("usuario");
                request.getSession().setAttribute("usuario", user.getIDLOGIN().toString());
                request.getSession().removeAttribute("IDusuario");
                request.getSession().setAttribute("IDusuario", user.getCODIGOUSUARIO());
                request.getSession().removeAttribute("privilegio");
                request.getSession().setAttribute("privilegio", privi);


                response.sendRedirect("inicio.jsp");
            }
          }else{
               String msg="Valores Incorrectos";
                request.getSession().removeAttribute("mensaje");
                request.getSession().setAttribute("mensaje", msg);
                response.sendRedirect("login.jsp"); 
          }
      }
      
      if(path.equals("/registrarProducto"))
      {

        String usuario=request.getParameter("txtusuario");
        String password=request.getParameter("txtpassword");
        
        String msg="ALGUN MENSAJE";
        request.getSession().removeAttribute("mensajeProducto");
        request.getSession().setAttribute("mensajeProducto", msg);
        response.sendRedirect("inicio.jsp");
              
      }
      
      if(path.equals("/cerrarSession"))
      {
        request.getSession().removeAttribute("usuario");
        request.getSession().removeAttribute("IDusuario");
        request.getSession().removeAttribute("privilegio");
        request.getSession().invalidate();
        response.sendRedirect("login.jsp");
              
      }
        if(path.equals("/registrarUsuario"))
      {
          int DNI=Integer.parseInt(request.getParameter("txtDNI")) ;
          String idlogin=request.getParameter("txtidlogin");
          String idpassword=request.getParameter("txtidpassword");
          String estado=request.getParameter("selecestado");
          String nombre=request.getParameter("txtNombres");
          String appat=request.getParameter("txtApellidoPat");
          String apmat=request.getParameter("txtApellidoMat");
          String direccion=request.getParameter("txtdireccion");
          String email=request.getParameter("txtEmail");
          int celular= Integer.parseInt(request.getParameter("txtcelular")) ;
          int fijo=Integer.parseInt(request.getParameter("txttelfijo"));
          Date fechaingreso=Date.valueOf(request.getParameter("txtfecha"));
          
          
          usuarioBeans ruser = new usuarioBeans();
          ruser.setIDLOGIN(idlogin);
          ruser.setESTADO(estado);
          ruser.setNOMBRE(nombre);
          ruser.setAPELLIDOPATERNO(appat);
          ruser.setAPELLIDOMATERNO(apmat);
          ruser.setDIRECCION(direccion);
          ruser.setEMAIL(email);
          ruser.setCELULAR(celular);
          ruser.setFIJO(fijo);
          ruser.setFECHAINGRESO(fechaingreso);
          
          
          String msg =usuarioDAO.insertarUsuario(ruser);
          
         
              response.sendRedirect("inicio.jsp?msg='"+msg+"'");
                  
      }
             }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
