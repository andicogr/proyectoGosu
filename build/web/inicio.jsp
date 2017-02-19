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
    </head>
    <body>
        <% String nombrePrivilegio = ""; %>
        <%if(session.getAttribute("privilegio") !=null){ %>
        <% nombrePrivilegio = (String)request.getSession().getAttribute("privilegio"); %> 
        <%}%>
        <table border="1" style="width: 100%">
            <tr>
                <td style="height: 200px">
                    Banner de la empresa
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
                                </ul>
                            </td>
                            <td style="width: 79%; height: 500px">


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
                    
                    
                    
                    <%}else{%>
                     <%@include file="prueba.jsp" %>
            <%}%>
            
        <%}else{%>
             <%@include file="sesionExpirada.jsp" %>
        <%}%>
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
