/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.controlador;


import com.google.gson.Gson;
import com.pe.grupoads.DAO.clienteDAO;
import com.pe.grupoads.DAO.componenteDAO;
import com.pe.grupoads.DAO.productoDAO;
import com.pe.grupoads.DAO.proformaDAO;
import com.pe.grupoads.DAO.reclamoDAO;
import com.pe.grupoads.beans.clienteBeans;
import com.pe.grupoads.beans.componenteBeans;
import com.pe.grupoads.beans.productoBeans;
import com.pe.grupoads.beans.proformaBeans;
import com.pe.grupoads.beans.reclamoBeans;
import com.pe.grupoads.beans.usuarioBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raul
 */
@WebServlet(name = "servletReclamo", urlPatterns = {"/servletReclamo","/registrarReclamo","/autocompletarComponente", "/validarNumeroProforma"})
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
         try {
            Integer idCliente = null;
            Integer numeroProforma = Integer.parseInt(request.getParameter("numeroProforma"));
            String idClienteStr = request.getParameter("idCliente");
            String dniCliente = request.getParameter("dniCliente");
            String nombreCliente = request.getParameter("nombreCliente");
            if(!idClienteStr.equals("")){
                idCliente = Integer.parseInt(idClienteStr);
            }else{
                idCliente = clienteDAO.insertarCliente(dniCliente, nombreCliente);
            }
            
            //int coduser=Integer.parseInt(request.getParameter("txtusuario"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date fechareclamo = format.parse(request.getParameter("txtfecha"));
            
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

            String asunto=request.getParameter("asunto");
            String descripcion=request.getParameter("descripcion");

            reclamoBeans rerecl = new reclamoBeans();
            rerecl.setFechareclamo(fechareclamo);
            rerecl.setAsunto(asunto);
            rerecl.setDescripcion(descripcion);
            rerecl.setCodigousuario(idUsuario);
            rerecl.setCodcliente(idCliente);
            rerecl.setCodigoProforma(numeroProforma);

            String msg =reclamoDAO.registrarReclamo(rerecl);
            proformaDAO.anularProforma(numeroProforma);

            response.sendRedirect("inicio.jsp?op=regrecl&msg='"+msg+"'");
             
            } catch (ParseException ex) {
                Logger.getLogger(servletReclamo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else if(path.equals("/autocompletarComponente")){
                String nombreComponente = request.getParameter("nombreComponente");
                List<componenteBeans> componentes = componenteDAO.obtenerComponentesPorNombre(nombreComponente);

                List<Map<String, Object>> mapComponentes = new ArrayList<Map<String, Object>>();
                for(componenteBeans x: componentes){
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("id", x.getCodComponente());
                    map.put("label", x.getNombre());
                    map.put("nombre", x.getNombre());
                    map.put("concentracion", x.getConcentracion());
                    map.put("unidad", x.getUnidad());

                    mapComponentes.add(map);
                }
                response.setContentType("application/json");
                new Gson().toJson(mapComponentes, response.getWriter());
                
            }
        if(path.equals("/validarNumeroProforma")){
                String respuesta = "incorrecto";
                String numeroProforma = request.getParameter("numeroProforma");
                if(numeroProforma != null && !numeroProforma.equals("")){
                    proformaBeans proforma = proformaDAO.obtenerProformaPorId(Integer.parseInt(numeroProforma));
                    if(proforma != null && proforma.getEstado().equals("pagada")){
                        respuesta = "correcto";
                    }
                }

                response.setContentType("application/json");
                new Gson().toJson(respuesta, response.getWriter());
                
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
