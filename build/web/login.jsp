<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/estilosLogin.css" type="text/css" rel="stylesheet"/>

    </head>
    
    <body  >
        <form id="frmlogin" method="post" action="logearUsuario" name="frmlogin">
            
                    <table >
                        <tr>
                            <td id="titPagina" colspan="2" align="center" >Ingreso</td>
                        </tr>
                        <tr id="user">
                            <td >Usuario</td>
                            <td><input type="text" name="txtusuario"  /></td>
                            
                        </tr>
                        <tr id="pass">
                            <td  >Password</td>
                            <td><input type="password" name="txtpassword" ></td>
                        </tr>
                        <tr id="betn" align="center">
                            <td colspan="2" align="center"><input id="btnenviar" type="submit" value="Ingresar" name="ingresar"/>
                        </tr>
                        <tr>
                            <td colspan="2"><font color="red">
                                <%if(session.getAttribute("mensaje") !=null){ %>
                                <%=(String)request.getSession().getAttribute("mensaje") %> 
                                <%}%>
                                </font>
                                                               
                            </td>
                        </tr>
                        
                    </table>
                   
        </form>
    </body>
 
</html>
