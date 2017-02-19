/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.controlador;

import com.pe.grupoads.DAO.usuarioDAO;
import com.pe.grupoads.beans.usuarioBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raul
 */
@WebServlet(name = "servletUsuario", urlPatterns = {"/servletUsuario","/registrarUsuario","/listar","/editarUsuario"})
public class servletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path=request.getServletPath();
        
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
          ruser.setDNI(DNI);
          ruser.setIDLOGIN(idlogin);
          ruser.setIDPASSWORD(idpassword);
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
          
         
              response.sendRedirect("inicio.jsp?op=agregaruser&msg='"+msg+"'");
                  
            }
      if(path.equals("/listar"))
          {
              request.setAttribute("art",usuarioDAO.Listar());
           request.getRequestDispatcher(("inicio.jsp?op=listaruser")).forward(request,response);
        }
     //request.setAttribute("art", usuarioDAO.Listar());
      // request.getRequestDispatcher(("inicio.jsp?op=listaruser")).forward(request, response);
        if(path.equals("/editarUsuario"))
      {
          int coduser=Integer.parseInt(request.getParameter("coduserEdit"));
          int DNI=Integer.parseInt(request.getParameter("DNIEdit")) ;
          String idlogin=request.getParameter("usuarioEdit");
          String idpassword=request.getParameter("passwordEdit");
          String estado=request.getParameter("estadoEdit");
          String nombre=request.getParameter("NombresEdit");
          String appat=request.getParameter("ApellidopatEdit");
          String apmat=request.getParameter("ApellidomatEdit");
          String direccion=request.getParameter("direccionEdit");
          String email=request.getParameter("EmailEdit");
          int celular= Integer.parseInt(request.getParameter("celularEdit")) ;
          int fijo=Integer.parseInt(request.getParameter("FijoEdit"));
          Date fechaingreso=Date.valueOf(request.getParameter("fechaEdit"));
          
          
          usuarioBeans euser = new usuarioBeans();
          euser.setCODIGOUSUARIO(coduser);
          euser.setDNI(DNI);
          euser.setIDLOGIN(idlogin);
          euser.setIDPASSWORD(idpassword);
          euser.setESTADO(estado);
          euser.setNOMBRE(nombre);
          euser.setAPELLIDOPATERNO(appat);
          euser.setAPELLIDOMATERNO(apmat);
          euser.setDIRECCION(direccion);
          euser.setEMAIL(email);
          euser.setCELULAR(celular);
          euser.setFIJO(fijo);
          euser.setFECHAINGRESO(fechaingreso);
          
          
          String msg =usuarioDAO.editarUsuario(euser);
          
         
              response.sendRedirect("inicio.jsp?op=agregaruser&msg='"+msg+"'");
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
