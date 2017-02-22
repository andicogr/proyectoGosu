<%-- 
    Document   : nuevoProducto
    Created on : 20-feb-2017, 1:47:15
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
       <form id="frmRegis" method="post" action="" name="frmregister">
        <table>
            <TR>
                <td colspan="2">Registrar Nuevo Producto</td>
            </TR>
            
            <tr>
                <td id="col1"></td>
                <td id="col2"><input type="hidden" name="txtcodpro" size="70"/></td>
            </tr>
             <tr>
                <td id="col1">Nombre del Producto</td>
                <td id="col2"><input type="text" name="txtnompro" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Descripcion</td>
                <td id="col2"><input type="text" name="txtdescripcion" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Precio Venta</td>
                <td id="col2"><input type="number" name="txtprecio" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Cantidad</td>
                <td id="col2"><input type="number" name="txtstock" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Componentes</td>
                <td id="col2"><input type="number" name="txtstock" size="70"/></td>
            </tr>
           <tr>
                 <td id="col1">Receta</td>
                  <td id="col2">
            <select name="selecreceta">
                <option>Si</option>
                 <option>No</option>
            </select>
             
              </td>
            <tr>
                <td id="col1">Fecha Vencimiento</td>
                <td id="col2"><input type="date" name="txtfechavenc" size="70"/></td>
            </tr>
            
             
           
            <tr><td colspan="2" id="msg" align="center">
           <%String mensaje1=request.getParameter("msg");
          if(mensaje1!=null){out.println(mensaje1);}%>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input id="btnenviar"type="submit" value="Registrar" name="registrar"/>
                 <input id="btncancelar" type="reset" value="Limpiar" name="cancelar"/></td>
            </tr>
             
           
        </table>
        </form>
    </body>
</html>
