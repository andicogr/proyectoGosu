/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.grupoads.controlador;

import com.google.gson.Gson;
import com.pe.grupoads.DAO.clienteDAO;
import com.pe.grupoads.DAO.productoDAO;
import com.pe.grupoads.DAO.proformaDAO;
import com.pe.grupoads.beans.clienteBeans;
import com.pe.grupoads.beans.detalleProformaBeans;
import com.pe.grupoads.beans.productoBeans;
import com.pe.grupoads.beans.proformaBeans;
import com.pe.grupoads.beans.usuarioBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
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
 * @author Andico
 */
@WebServlet(name = "servletVentas", urlPatterns = {"/servletVentas", "/ventas/autocompletarProducto", "/abrirFormularioBuscarProducto",
    "/registrarProforma", "/obtenerClientePorDni", "/pagarProforma", "/anularProforma","/realizarPagoProforma"})
public class servletVentas extends HttpServlet {

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
        Integer IDUser = (Integer)request.getSession().getAttribute("IDusuario");
        if(IDUser==null && !path.equals("/logearUsuario")){
            response.sendRedirect("sesionExpirada.jsp");
        }else{
            if(path.equals("/ventas/autocompletarProducto")){
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
                    
                    List<productoBeans> productosSimilares = productoDAO.obtenerProductosSimilares(Integer.parseInt(x.getCodproducto()));
                    List<Map<String, Object>> mapProductosSimilares = new ArrayList<Map<String, Object>>();
                    for(productoBeans y: productosSimilares){
                        Map<String, Object> subMap = new HashMap<String, Object>();
                        subMap.put("id", y.getCodproducto());
                        subMap.put("label", y.getNombproducto());
                        subMap.put("nombre", y.getNombproducto());
                        subMap.put("descripcion", y.getDescripcion());
                        subMap.put("precio", y.getPrecioventa());
                        subMap.put("receta", y.getReceta());
                        subMap.put("stock", y.getStock());
                        mapProductosSimilares.add(subMap);
                    }
                    map.put("similares", mapProductosSimilares);
                    mapProductos.add(map);
                }
                response.setContentType("application/json");
                new Gson().toJson(mapProductos, response.getWriter());
                
            }else if(path.equals("/abrirFormularioBuscarProducto")){

                response.sendRedirect("ventas/formularioBuscarProducto.jsp");
            }else if(path.equals("/obtenerClientePorDni")){
                String dniCliente = request.getParameter("dniCliente");
                clienteBeans cliente = clienteDAO.obtenerClientePorDni(dniCliente);
                response.setContentType("application/json");
                new Gson().toJson(cliente, response.getWriter());
                
            }else if(path.equals("/registrarProforma")){
                
                try {
                    
                    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    
                    Date fechaProforma = format.parse(request.getParameter("fechaProforma"));

                    Double montoTotal = Double.parseDouble(request.getParameter("montoTotal"));

                    proformaBeans proforma = new proformaBeans();
                    proforma.setFechaEmision(fechaProforma);
                    proforma.setInportePorforma(montoTotal);
                    proforma.setEstado("emitido");
                    
                    Integer idProforma = proformaDAO.insertarProforma(proforma, IDUser);
                    
                    
                    String[] detalleIdProductos = request.getParameterValues("detalleIdProducto");
                    String[] detalleCantidades = request.getParameterValues("detalleCantidad");
                    String[] detallePrecios = request.getParameterValues("detallePrecio");
                    String[] detallePreciosTotales = request.getParameterValues("detallePrecioTotal");
                    
                    Integer cont = detalleIdProductos.length;
                    
                    for (int i = 0; i < cont; i++) {
                        Integer idProducto = Integer.parseInt(detalleIdProductos[i]);
                        Integer cantidad = Integer.parseInt(detalleCantidades[i]);
                        Double precioUnitario = Double.parseDouble(detallePrecios[i]);
                        Double precioTotal = Double.parseDouble(detallePreciosTotales[i]);
                        
                        detalleProformaBeans detalle = new detalleProformaBeans();
                        detalle.setCodProducto(idProducto);
                        detalle.setCantidad(cantidad);
                        detalle.setPrecioUnitario(precioUnitario);
                        detalle.setPrecioTotal(precioTotal);
                        
                        proformaDAO.insertarProformaDetalle(detalle, idProforma);
                    }
                    
                    
                    //response.sendRedirect("ventas/formularioBuscarProducto.jsp");
                } catch (ParseException ex) {
                    Logger.getLogger(servletVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                response.sendRedirect("inicio.jsp?op=vender_producto");
            }else if(path.equals("/pagarProforma")){
                Integer idProforma = Integer.parseInt(request.getParameter("idProforma"));
                proformaBeans proforma = proformaDAO.obtenerProformaPorId(idProforma);

                request.getSession().setAttribute("proforma", proforma);
                response.sendRedirect("inicio.jsp?op=pagar_proforma");
            }else if(path.equals("/anularProforma")){
                Integer idProforma = Integer.parseInt(request.getParameter("idProforma"));
                proformaDAO.anularProforma(idProforma);

                response.sendRedirect("inicio.jsp?op=cajero");
            }else if(path.equals("/realizarPagoProforma")){
                Integer idProforma = Integer.parseInt(request.getParameter("idProforma"));
                String idClienteStr = request.getParameter("idCliente");
                String dniCliente = request.getParameter("dniCliente");
                String nombreCliente = request.getParameter("nombreCliente");
                Integer idCliente = null;
                if(idClienteStr.equals("") && !dniCliente.equals("") && !nombreCliente.equals("")){
                    idCliente = clienteDAO.insertarCliente(dniCliente, nombreCliente);
                }else{
                    try {
                        idCliente = Integer.parseInt(idClienteStr);
                    } catch (Exception e) {
                        idCliente = null;
                    }
                    
                }
                proformaDAO.pagarProforma(idProforma, idCliente);

                response.sendRedirect("inicio.jsp?op=cajero");
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
