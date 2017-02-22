/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.controlador;

import com.google.gson.Gson;
import com.pe.grupoads.DAO.productoDAO;
import com.pe.grupoads.beans.productoBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "servletProducto", urlPatterns = {"/servletProducto","/listarpro","/actualizarproducto","/registrarProductoServlet",
"/autocompletarProductoStock"})
public class servletProducto extends HttpServlet {

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
        String path=request.getServletPath();
        
        if(path.equals("/listarpro"))
          {
              request.setAttribute("pro",productoDAO.listar());
           request.getRequestDispatcher(("inicio.jsp?op=actializarpro")).forward(request,response);
        }
        if(path.equals("/actualizarproducto"))
        {
            Integer idProducto = Integer.parseInt(request.getParameter("selecproducto"));
            Integer CantidadAgregar=Integer.parseInt(request.getParameter("txtCantidad"));
            
           
            productoDAO.actualizarStockProducto(idProducto, CantidadAgregar);
            request.setAttribute("pro",productoDAO.listar());
            request.getRequestDispatcher(("inicio.jsp?op=actializarpro")).forward(request,response);
        }
        if(path.equals("/registrarProductoServlet"))
        {

            String nombreProducto = request.getParameter("nombreProducto");
            Double precioVenta = Double.parseDouble(request.getParameter("precioVenta"));
            Integer stockInicial = Integer.parseInt(request.getParameter("stockInicial"));
            String receta = request.getParameter("receta");
            String descripcion = request.getParameter("descripcion");

            String[] idComponenetes = request.getParameterValues("idComponentes");
            if(idComponenetes == null){
                idComponenetes = new String[0];
            }

            productoBeans producto = new productoBeans();
            producto.setNombproducto(nombreProducto);
            producto.setPrecioventa(precioVenta);
            producto.setStock(stockInicial);
            producto.setReceta(receta);
            producto.setDescripcion(descripcion);
            Integer idProducto = productoDAO.insertarProducto(producto);
            int cont = idComponenetes.length;
            for (int i = 0; i < cont; i++) {
                productoDAO.insertarComponenetesPorProducto(Integer.parseInt(idComponenetes[i]), idProducto);

            }

            request.getRequestDispatcher(("inicio.jsp?op=registrarpro")).forward(request,response);

        }
        if(path.equals("/autocompletarProductoStock")){
                String nombreProducto =request.getParameter("nombreProducto");
                List<productoBeans> productos = productoDAO.obtenerProductosPorNombre(nombreProducto);

                List<Map<String, Object>> mapProductos = new ArrayList<Map<String, Object>>();
                for(productoBeans x: productos){
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("id", x.getCodproducto());
                    map.put("label", x.getNombproducto());
                    map.put("nombre", x.getNombproducto());
                    map.put("descripcion", x.getDescripcion());
                    map.put("precio", x.getPrecioventa());
                    map.put("receta", x.getReceta());
                    map.put("stock", x.getStock());
                    mapProductos.add(map);
                }
                response.setContentType("application/json");
                new Gson().toJson(mapProductos, response.getWriter());
                
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
