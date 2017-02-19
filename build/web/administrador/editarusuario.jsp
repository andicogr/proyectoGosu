<%-- 
    Document   : editarusuario
    Created on : 07-feb-2017, 23:32:54
    Author     : Raul
--%>

<%@page import="com.pe.grupoads.DAO.usuarioDAO"%>
<%@page import="com.pe.grupoads.beans.usuarioBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form id="frmRegis" method="post" action="editarUsuario" name="frmregister">
        <table>
            <% String id = request.getParameter("iduser"); %>
            <% usuarioBeans user11 = usuarioDAO.ListarPorId(Integer.parseInt(id)); %>
            <TR>
                <td  id="tituloregistro" colspan="2">Editar Usuario</td>
            </TR>
             <tr>
                <td id="col1">Codigo</td>
                <td id="col2"><input type="text" name="coduserEdit" value="<%=user11.getCODIGOUSUARIO()%>" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Nombres</td>
                <td id="col2"><input type="text" name="NombresEdit" value="<%=user11.getNOMBRE()%>" size="70"/></td>
            </tr>
             <tr>
                <td id="col1">Apellido Paterno</td>
                <td id="col2"><input type="text" name="ApellidopatEdit" value="<%=user11.getAPELLIDOPATERNO()%>" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Apellido Materno</td>
                <td id="col2"><input type="text" name="ApellidomatEdit" value="<%=user11.getAPELLIDOMATERNO()%>" size="70"/></td>
            </tr>
             <tr>
                <td id="col1">Email</td>
                <td id="col2"><input type="text" name="EmailEdit" value="<%=user11.getEMAIL() %>" size="70"/></td>
            </tr>
           
             <tr>
                  
                  <td id="col1">
                      DNI
                  </td>
                  <td id="col2"><input type="text" name="DNIEdit" value="<%=user11.getDNI() %>" size="70"/></td>
            </tr>
           
            <tr>
                <td id="col1">Usuario</td>
                <td id="col2">
                    <input type="text"  name="usuarioEdit" value="<%=user11.getIDLOGIN() %>" size="30"/>
                    
                </td>
            </tr>
            <tr>
                <td id="col1">Password</td>
                <td id="col2">
                    <input type="password"  name="passwordEdit" value="<%=user11.getIDPASSWORD() %>" size="30"/>
                    
                </td>
            </tr>
            <tr>
                <td id="col1">Direccion</td>
                <td id="col2"><input type="text" name="direccionEdit" value="<%=user11.getDIRECCION() %>" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Celular</td>
                <td id="col2"><input type="number" name="celularEdit" value="<%=user11.getCELULAR() %>" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Fijo</td>
                <td id="col2"><input type="number" name="FijoEdit" value="<%=user11.getFIJO() %>" size="70"/></td>
            </tr>
            <tr>
                <td id="col1">Estado</td>
                <td id="col2">
                    <input type="text"  name="estadoEdit" value="<%=user11.getESTADO() %>" size="30"/>
                    
                </td>
            </tr>
            <tr>
                <td id="col1">Fecha Ingreso</td>
                <td id="col2"><input type="date" name="fechaEdit" value="<%=user11.getFECHAINGRESO() %>" size="70"/></td>
            </tr>
            <tr><td colspan="2" id="msg" align="center">
            <%  String mensaje11=request.getParameter("msg");
            if(mensaje11!=null){out.println(mensaje11);
          }
          %>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input id="btnenviar"type="submit" value="Editar" name="Editar"/>
                 <input id="btncancelar" type="reset" value="Cancelar" name="cancelar"/></td>
            </tr>
             
           
        </table>
        </form>
    </body>
</html>
