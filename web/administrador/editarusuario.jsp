<%-- 
    Document   : editarusuario
    Created on : 07-feb-2017, 23:32:54
    Author     : Raul
--%>

<%@page import="com.pe.grupoads.DAO.usuarioDAO"%>
<%@page import="com.pe.grupoads.beans.usuarioBeans"%>



    <div class="content-box-large">

        <div class="panel-body">
            <form class="form-horizontal" role="form" action="editarUsuario">
                <% String id = request.getParameter("iduser"); %>
                <% usuarioBeans user11 = usuarioDAO.ListarPorId(Integer.parseInt(id)); %>
                <fieldset>
                    <legend>Editar Usuario - <%=user11.getIDLOGIN() %></legend>
                    <div class="form-group">
                      <label for="coduserEdit" class="col-sm-2 control-label">Codigo</label>
                      <div class="col-sm-2">
                         <input type="text" class="form-control" name="coduserEdit" value="<%=user11.getCODIGOUSUARIO()%>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="NombresEdit" class="col-sm-2 control-label">Nombres</label>
                      <div class="col-sm-4">
                         <input type="text" class="form-control" name="NombresEdit" value="<%=user11.getNOMBRE()%>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="ApellidopatEdit" class="col-sm-2 control-label">Apellido Paterno</label>
                      <div class="col-sm-4">
                         <input type="text" class="form-control" name="ApellidopatEdit" value="<%=user11.getAPELLIDOPATERNO()%>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="ApellidomatEdit" class="col-sm-2 control-label">Apellido Materno</label>
                      <div class="col-sm-4">
                         <input type="text" class="form-control" name="ApellidomatEdit" value="<%=user11.getAPELLIDOMATERNO()%>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="EmailEdit" class="col-sm-2 control-label">Email</label>
                      <div class="col-sm-4">
                         <input type="text" class="form-control" name="EmailEdit" value="<%=user11.getEMAIL() %>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="DNIEdit" class="col-sm-2 control-label">DNI</label>
                      <div class="col-sm-2">
                         <input type="text" class="form-control" name="DNIEdit" value="<%=user11.getDNI() %>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="usuarioEdit" class="col-sm-2 control-label">Usuario</label>
                      <div class="col-sm-2">
                         <input type="text" class="form-control" name="usuarioEdit" value="<%=user11.getIDLOGIN() %>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="passwordEdit" class="col-sm-2 control-label">Clave</label>
                      <div class="col-sm-2">
                         <input type="text" class="form-control" name="passwordEdit" value="<%=user11.getIDPASSWORD() %>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="direccionEdit" class="col-sm-2 control-label">Direccion</label>
                      <div class="col-sm-4">
                         <input type="text" class="form-control" name="direccionEdit" value="<%=user11.getDIRECCION() %>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="celularEdit" class="col-sm-2 control-label">Celular</label>
                      <div class="col-sm-2">
                         <input type="text" class="form-control" name="celularEdit" value="<%=user11.getCELULAR() %>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="FijoEdit" class="col-sm-2 control-label">Fijo</label>
                      <div class="col-sm-2">
                         <input type="text" class="form-control" name="FijoEdit" value="<%=user11.getFIJO() %>">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="estadoEdit" class="col-sm-2 control-label">Estado</label>
                      <div class="col-sm-2">
                         <input type="text" class="form-control" name="estadoEdit" value="<%=user11.getESTADO() %>">
                      </div>
                    </div>
                </fieldset>
                <br/>
                <fieldset>
                    <legend></legend>
                    <div class="form-group">

                        <div class="col-sm-2">
                            <button type="submit" class="btn btn-primary">Registrar</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>