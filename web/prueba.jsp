<%-- 
    Document   : prueba
    Created on : 29-ene-2017, 20:09:24
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
<h1>Hello World Prro!</h1>
        <form id="frmlogin" method="post" action="registrarProducto" name="frmlogin">
            
                    <table >
                        <tr>
                            <td id="titPagina" colspan="2" align="center" >Registrar Producto</td>
                        </tr>
                        <tr id="user">
                            <td >Producto*</td>
                            <td><input type="text" name="txtusuario" /></td>
                            
                        </tr>
                        <tr id="pass">
                            <td  >Cantidad*</td>
                            <td><input type="text" name="txtpassword" ></td>
                        </tr>
                        <tr id="descrip">
                            <td  >Descripcion*</td>
                            <td><input type="text" name="txtDescricion" ></td>
                        </tr>
                        <tr id="betn" align="center">
                            <td colspan="2" align="center"><input id="btnenviar" type="submit" value="Registrar" name="ingresar"/>
                        </tr>
                        <tr>
                            <td colspan="2"><font color="red">
                                <%if(session.getAttribute("mensajeProducto") !=null){ %>
                                <%=(String)request.getSession().getAttribute("mensajeProducto") %> 
                                <%}%>
                                </font>
                                                               
                            </td>
                        </tr>
                        
                    </table>
                   
        </form>
                                
                     
    </body>
</html>
