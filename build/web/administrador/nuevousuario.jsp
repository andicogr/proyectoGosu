

    <div class="content-box-large">

        <div class="panel-body">
            <form class="form-horizontal" role="form" action="registrarUsuario">
                <fieldset>
                    <legend>Registrar Usuario</legend>
                    <div class="form-group">
                      <label for="txtNombres" class="col-sm-2 control-label">Nombres</label>
                      <div class="col-sm-4">
                         <input type="text" required="true" class="form-control" name="txtNombres">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="txtApellidoPat" class="col-sm-2 control-label">Apellido Paterno</label>
                      <div class="col-sm-4">
                         <input type="text" required="true" class="form-control" name="txtApellidoPat">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="txtApellidoMat" class="col-sm-2 control-label">Apellido Materno</label>
                      <div class="col-sm-4">
                         <input type="text" required="true" class="form-control" name="txtApellidoMat">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="txtDNI" class="col-sm-2 control-label">DNI</label>
                      <div class="col-sm-2">
                         <input type="text" required="true" onkeypress='return event.charCode >= 48 && event.charCode <= 57' class="form-control" name="txtDNI">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="txtidlogin" class="col-sm-2 control-label">Login</label>
                      <div class="col-sm-2">
                         <input type="text" required="true" class="form-control" name="txtidlogin">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="txtpassword" class="col-sm-2 control-label">Password</label>
                      <div class="col-sm-2">
                          <input type="password" required="true" class="form-control" name="txtpassword">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="txtdireccion" class="col-sm-2 control-label">Direccion</label>
                      <div class="col-sm-4">
                         <input type="text" required="true" class="form-control" name="txtdireccion">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="txtEmail" class="col-sm-2 control-label">Email</label>
                      <div class="col-sm-4">
                         <input type="text" required="true" class="form-control" name="txtEmail">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="txtcelular" class="col-sm-2 control-label">Celular</label>
                      <div class="col-sm-2">
                         <input type="text" required="true" onkeypress='return event.charCode >= 48 && event.charCode <= 57' class="form-control" name="txtcelular">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="txttelfijo" class="col-sm-2 control-label">Telefono Fijo</label>
                      <div class="col-sm-2">
                         <input type="text" required="true" onkeypress='return event.charCode >= 48 && event.charCode <= 57' class="form-control" name="txttelfijo">
                      </div>
                    </div>
                     <div class="form-group">
                        <label for="selecestado" class="col-sm-2 control-label">Estado</label>
                        <div class="col-sm-2">
                            <select name="selecestado" id="receta" class="form-control" id="select-1">
                                <option value="Activo">Activo</option>
                                <option value="Inactivo">Inactivo</option>
                            </select>
                        </div>
                    </div>
                </fieldset>
                <br/>

                    <%String mensaje1=request.getParameter("msg");
                   if(mensaje1!=null){out.println(mensaje1);}%>

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