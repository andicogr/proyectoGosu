<%-- 
    Document   : registroreclamo
    Created on : 19-feb-2017, 1:34:51
    Author     : Raul
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
                <form id="frmRegisrecl" method="post" action="registrarReclamo" name="frmregisrecl">
         <% Integer idUsuario = (Integer) session.getAttribute("IDusuario");%>
         <% String nombreUsuario = (String) session.getAttribute("usuario");%>
         <script > 
             function abrirVentana(url) {
                 window.open("reclamoCliente/verificarStock.jsp"
             ,Verificar Stock,"width=400,height=400,resizable=false");
         }
          </script>   
             
         
          <a href="#" onclick="abrirVentana(reclamoCliente/verificarStock.jsp)">Verificar Stock</a>
                                          
        <table border="1">
           
            <TR>
                <td colspan="2">Registro de Reclamo</td>
            </TR>
            
            <tr>
                <td >Codigo</td>
                <td ><input type="text" name="txtcodrecl" size="70"/></td>
            </tr>
             <tr>
                <td >Usuario</td>
                <td ><input type="text" name="txtcodrecl" readonly="readonly" value="<%=nombreUsuario%>" size="70"/></td>
            </tr>
            <tr>
                <td >Fecha</td>
                <td ><input type="date" name="txtfecha" size="70"/></td>
            </tr>
            <tr>
                <td >Asunto</td>
                <td ><input type="text" name="txtasunto" size="70"/></td>
            </tr>
            <tr>
                <td >Solucion</td>
                  <td >
            <select name="selecsolu">
                 
                 <option>Si</option>
                 <option>No</option>
                 
             </select>
             
              </td>
            </tr>
            <tr>
                <td >Descripcion</td>
                <td ><input type="text" name="txtdescrip" size="70"/></td>
            </tr>
           
           
            <tr><td colspan="2"  align="center">
           <%String mensaje2=request.getParameter("msg");
          if(mensaje2!=null){out.println(mensaje2);}%>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input id="btnenvi"type="submit" value="Registrar" name="registrar"/>
                 <input id="btncancel" type="reset" value="Limpiar" name="cancelar"/></td>
            </tr>
             
           
        </table>
        </form>
    </body>
</html>
