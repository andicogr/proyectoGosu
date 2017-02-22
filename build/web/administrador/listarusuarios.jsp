<%-- 
    Document   : listarusuarios
    Created on : 07-feb-2017, 19:12:15
    Author     : LAB05-17
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.pe.grupoads.beans.usuarioBeans"%>



<script src="jquery/jquery.js"></script>

    <div class="content-box-large">

        <div class="panel-body"> 
                <fieldset>
                    <%ArrayList<usuarioBeans> listar=(ArrayList<usuarioBeans>)request.getAttribute("art");%>
                    <legend>Usuarios</legend>
                    <table class="table table-condensed" id="tableDetalleProforma">
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido Paterno</th>
                            <th>apellido Materno</th>
                            <th>DNI</th>
                            <th>Login</th>
                            <th>Dirección</th>
                            <th>Celular</th>
                            <th>Email</th>
                            <!--th>Fecha de ingreso</th-->
                            <th>Estado</th>
                            <th>Accion</th>
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
                            <%--td>
                                <%if(x.getFECHAINGRESO()==null){%>
                                    
                                <%}else{%>
                                    <%=x.getFECHAINGRESO() %>
                                <%}%>
                            </td--%>
                            <td><%=x.getESTADO() %></td>
                            <td id="col2"><a href="inicio.jsp?op=editaruser&iduser=<%=x.getCODIGOUSUARIO()%>" class="btn btn-success btn-xs" role="button" >Editar</a></td>
                            </tr>
                        <% } %>
                    </table>

                </fieldset>

            </form>
        </div>
    </div>
