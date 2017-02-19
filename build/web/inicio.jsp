<%-- 
    Document   : inicio
    Created on : 29-ene-2017, 18:54:12
    Author     : Raul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="css/inicio.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <% String nombrePrivilegio = ""; %>
        <%if(session.getAttribute("privilegio") !=null){ %>
        <% nombrePrivilegio = (String)request.getSession().getAttribute("privilegio"); %> 
        <%}%>
        <table border="1" style="width: 100%">
            <tr>
                <td style="height: 200px;">
                    <div id="div_banner" style="width:100%; ">
                        <img src="imagenes/banner_principal.jpg"/>
                    </div>
                    
                </td>
            </tr>
            <tr>
                <td id="cerrar_sesion_link">
                    <div style="float: right">
                        <a  href="cerrarSession"  >Cerrar Sesion</a>
                    </div>
                </td>
            </tr>
            <tr>
                <td style="width: 100%">
                    <table border="1" style="width: 100%">
                        <tr>
                            <td style="width: 20%; height: 500px">
                                <ul>
                                  <%if(nombrePrivilegio.equals("administrador")){ %>
                                    <li> <a href="inicio.jsp?op=operaciones">Administrar Usuarios</a></li>
                                  <%}%>
                                    <%if(nombrePrivilegio.equals("administrador")){ %>
                                  <li> <a href="#">Registrar Producto</a></li>
                                  <%}%>
                                  <%if(nombrePrivilegio.equals("administrador") || nombrePrivilegio.equals("ventas")){ %>
                                  <li> <a href="#">Ventas</a></li>
                                  <%}%>
                                  <%if(nombrePrivilegio.equals("administrador") || nombrePrivilegio.equals("ventas")){ %>
                                  <li> <a href="inicio.jsp?op=acciones">Reclamo Cliente</a></li>
                                  <%}%>
                                </ul>
                            </td>
                            <td style="width: 79%; height: 500px; position: relative;">
                                <div style="margin-left: 0%;">

                                    <%if(session.getAttribute("IDusuario") !=null){ %>

                                    <%String op=(String)request.getParameter("op");%>

                                     <%if(op!=null){%>
                                                <%if(op.equals("operaciones")){%>
                                                <%@include file="administrador/operaciones.jsp" %>

                                                <%}%>
                                                <%if(op.equals("agregaruser")){%>
                                                <%@include file="administrador/nuevousuario.jsp" %>

                                                <%}%>
                                                <%if(op.equals("listaruser")){%>
                                                <%@include file="administrador/listarusuarios.jsp" %>

                                                <%}%>
                                                <%if(op.equals("editaruser")){%>
                                                <%@include file="administrador/editarusuario.jsp" %>

                                                <%}%>
                                                <%if(op.equals("acciones")){%>
                                                <%@include file="reclamoCliente/acciones.jsp" %>

                                                <%}%>
                                                <%if(op.equals("regrecl")){%>
                                                <%@include file="reclamoCliente/registroreclamo.jsp" %>

                                                <%}%>



                                                <%}else{%>
                                                 <%@include file="prueba.jsp" %>
                                        <%}%>

                                    <%}else{%>
                                         <%@include file="sesionExpirada.jsp" %>
                                    <%}%>
                                </div>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    Pie de pagina    
                </td>
            </tr>
        </table>
        
    </body>
</html>
