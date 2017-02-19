<%-- 
    Document   : listarusuarios
    Created on : 07-feb-2017, 19:12:15
    Author     : LAB05-17
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.pe.grupoads.beans.usuarioBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <%ArrayList<usuarioBeans> listar=(ArrayList<usuarioBeans>)request.getAttribute("art");%>
        <table border="1">
            <tr>
            
            <td>Nombre</td>
            <td>Apellido Paterno</td>
            <td>apellido Materno</td>
            <td>DNI</td>
            <td>Login</td>
            <td>Dirección</td>
            <td>Celular</td>
            <td>Email</td>
            <td>Fecha de ingreso</td>
            <td>Estado</td>
            <td>Accion</td>
            </tr>
            <%for(usuarioBeans x:listar){ %>
            <tr>
            <td><%=x.getNOMBRE() %></td>
            <td><%=x.getAPELLIDOPATERNO() %></td>
            <td><%=x.getAPELLIDOMATERNO() %></td>
            <td><%=x.getDNI() %></td>
            <td><%=x.getIDLOGIN() %></td>
            <td><%=x.getDIRECCION() %></td>
            <td><%=x.getCELULAR() %></td>
            <td><%=x.getEMAIL()%></td>
            <td><%=x.getFECHAINGRESO() %></td>
            <td><%=x.getESTADO() %></td>
            <td id="col2"><a href="inicio.jsp?op=editaruser&iduser=<%=x.getCODIGOUSUARIO()%>">Editar</a></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
