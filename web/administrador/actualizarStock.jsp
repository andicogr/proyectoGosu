<%-- 
    Document   : actualizarStock
    Created on : 20-feb-2017, 1:47:32
    Author     : Raul
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pe.grupoads.beans.productoBeans"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <body>
            <form id="frmRegis" method="post" action="actualizarproducto" name="frmregister">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>"Actualizar Producto"</title>
    </head>
    <%ArrayList<productoBeans> list=(ArrayList<productoBeans>)request.getAttribute("pro");%>
    <select name="selecproducto">
        <%for(productoBeans x:list){ %>
        <option  value="<%=x.getCodproducto() %>"><%=x.getNombproducto() %></option>
    <% } %>
    </select>
    <input type="text" name="txtCantidad">
    <input type="submit" name="Actualizar" value="Actualizar">
    
        </form>
         </body>
</head>
        


</html>
