/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.controlador;


import com.pe.grupoads.DAO.reclamoDAO;
import com.pe.grupoads.beans.reclamoBeans;
import com.pe.grupoads.beans.usuarioBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raul
 */
@WebServlet(name = "servletReclamo", urlPatterns = {"/servletReclamo","/registrarReclamo"})
public class servletReclamo extends HttpServlet {

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
        if(path.equals("/registrarReclamo"))
        {
          String codigoreclamo=request.getParameter("txtcodrecl") ;
          //int coduser=Integer.parseInt(request.getParameter("txtusuario"));
          Date fechareclamo=Date.valueOf(request.getParameter("txtfecha"));
          String asunto=request.getParameter("txtasunto");
          String descripcion=request.getParameter("selecsolu");
          String solucion=request.getParameter("txtdescrip");
          String codcliente=request.getParameter("txtApellidoMat");
          
          reclamoBeans rerecl = new reclamoBeans();
          rerecl.setCodigoreclamo(codigoreclamo);
         // rerecl.setCodigousuario(coduser);
          rerecl.setFechareclamo(fechareclamo);
          rerecl.setAsunto(asunto);
          rerecl.setDescripcion(descripcion);
          rerecl.setSolucion(solucion);
          rerecl.setCodcliente(codcliente);
          
          
          
          String msg =reclamoDAO.registrarReclamo(rerecl);
          
         
              response.sendRedirect("inicio.jsp?op=regrecl&msg='"+msg+"'");
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
