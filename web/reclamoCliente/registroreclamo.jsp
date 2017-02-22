<%-- 
    Document   : registroreclamo
    Created on : 19-feb-2017, 1:34:51
    Author     : Raul
--%>



<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<script src="jquery/jquery.js"></script>

    <div class="content-box-large">

        <div class="panel-body">
            <form class="form-horizontal" role="form" action="registrarReclamo">
         <% Integer idUsuario = (Integer) session.getAttribute("IDusuario");%>
         <% String nombreUsuario = (String) session.getAttribute("usuario");%>
                <fieldset>
                    <legend>Registrar Reclamo</legend>
                        <div class="form-group">
                          <label for="numeroProforma" class="col-sm-2 control-label">Numero Proforma</label>
                          <div class="col-sm-4">
                              <input type="text" class="form-control" required="true" name="numeroProforma" id="numeroProforma" onchange="validarNumeroProforma()">
                          </div>
                        </div>
                        <div class="form-group">
                          <label for="dniCliente" class="col-sm-2 control-label">DNI Cliente</label>
                          <div class="col-sm-2">
                              <input type="text" class="form-control" required="true" name="dniCliente" id="dniCliente" onchange="obtenerClientePorDNI()">
                             <input type="hidden" class="form-control" name="idCliente" id="idCliente">
                          </div>
                        </div>
                        <div class="form-group">
                          <label for="nombreCliente" class="col-sm-2 control-label">Nombre Cliente</label>
                          <div class="col-sm-4">
                             <input type="text" class="form-control" required="true" name="nombreCliente" id="nombreCliente">
                          </div>
                        </div>
                        <div class="form-group">
                          <label for="nombreUsuario" class="col-sm-2 control-label">Usuario</label>
                          <div class="col-sm-4">
                              <input type="text" class="form-control" readonly="readonly" name="nombreUsuario" value="<%=nombreUsuario%>">
                              <input type="hidden" class="form-control" name="idUsuario" id="idUsuario" value="<%=idUsuario%>">
                          </div>
                        </div>
                        <div class="form-group">
                          <label for="txtfecha" class="col-sm-2 control-label">Fecha</label>
                          <div class="col-sm-2">
                              <% Date today = new Date(); 
                                  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                             %>
                             <input type="text" readonly="readonly" class="form-control" name="txtfecha" id="txtfecha" value="<%=dateFormat.format(today)%>">
                          </div>
                        </div>
                        <div class="form-group">
                          <label for="asunto" class="col-sm-2 control-label">Asunto</label>
                          <div class="col-sm-4">
                             <input type="text" class="form-control" name="asunto" id="asunto">
                          </div>
                        </div>
                        <div class="form-group">
                            <label for="descripcion" class="col-sm-2 control-label">Descripcion</label>
                            <div class="col-sm-6">
                                <textarea class="form-control" name="descripcion" id="descripcion" rows="5"></textarea>
                            </div>
                        </div>
                </fieldset>
                                     <%String mensaje2=request.getParameter("msg");
          if(mensaje2!=null){out.println(mensaje2);}%>
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

<script type="text/javascript">
$( function() {
$(document).ready(function() {
  $(window).keydown(function(event){
    if(event.keyCode == 13) {
      event.preventDefault();
      return false;
    }
  });
});


} );

function validarNumeroProforma(){
    var numeroProforma = $("#numeroProforma").val();
    $.get("validarNumeroProforma", {numeroProforma: numeroProforma}, function(response){
        if(response === "incorrecto"){
           $("#numeroProforma").val("");
           alert("El numero de proforma no existe");
       }
    });
}

function obtenerClientePorDNI(){
    var dniCliente = $("#dniCliente").val();
    $.get("obtenerClientePorDni",{dniCliente: dniCliente}, function(response){
        if(response===null){
            alert("Cliente Nuevo!!");
            $("#nombreCliente").val("");
            $("#idCliente").val("");
        }else{
            $("#idCliente").val(response.codCliente);
            $("#nombreCliente").val(response.nombreCliente);
        }
    });
}
</script>