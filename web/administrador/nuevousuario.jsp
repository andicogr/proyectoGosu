<%-- 
    Document   : nuevousuario
    Created on : 06-feb-2017, 0:28:10
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
        <form id="frmRegis" method="post" action="registrarUsuario" name="frmregister">
        <table>
            <TR>
                <td colspan="2">Registro de Nuevo Usuario</td>
            </TR>
            
            <tr>
                <td id="col1">Nombres</td>
                <td id="col2"><input type="text" name="txtNombres" size="70"/></td>
            </tr>
             <tr>
                <td id="col1">Apellido paterno</td>
                <td id="col2"><input type="text" name="txtApellidoPat" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Apellido materno</td>
                <td id="col2"><input type="text" name="txtApellidoMat" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">DNI</td>
                <td id="col2"><input type="number" name="txtDNI" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Id Login</td>
                <td id="col2"><input type="text" name="txtidlogin" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Contraseña</td>
                <td id="col2"><input type="password" name="txtpassword" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Dirección</td>
                <td id="col2"><input type="text" name="txtdireccion" size="70"/></td>
            </tr>
            
             <tr>
                <td id="col1">Email</td>
                <td id="col2"><input type="text" name="txtEmail" size="70"/></td>
            </tr>
           <tr>
                <td id="col1">Celular</td>
                <td id="col2"><input type="number" name="txtcelular" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Telefono Fijo</td>
                <td id="col2"><input type="number" name="txttelfijo" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Fecha ingreso</td>
                <td id="col2"><input type="date" name="txtfecha" size="70"/></td>
            </tr>
             <tr>
                  
                  <td id="col1">Estado</td>
                  <td id="col2">
                  
             <select name="selecestado">
                 
                 <option>Activo</option>
                 <option>Inactivo</option>
                 
             </select>
             
              </td>
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
