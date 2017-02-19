    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<script src="jquery/jquery.js"></script>

    <div class="content-box-large">

        <div class="panel-body">
            <form class="form-horizontal" role="form" action="realizarPagoProforma">
                <fieldset>
                    <legend>Proforma-${proforma.codProforma}</legend>
                  <div class="form-group">
                      <input type="hidden" name="idProforma" value="${proforma.codProforma}"/>
                          
                    <label for="fechaProforma" class="col-sm-2 control-label">Fecha</label>
                    <div class="col-sm-2">
                       <input type="text" readonly="readonly" class="form-control" name="fechaProforma" id="fechaProforma" value="${proforma.fechaEmision}">
                    </div>
                    <div class="col-sm-6">
                    </div>
                    <div class="col-sm-2">
                        <a href="anularProforma?idProforma=${proforma.codProforma}" onclick="return confirm('Esta seguro de anular la proforma?')" class="btn btn-danger" role="button">Anular</a>
                    </div>
                  </div>
                </fieldset>

                <fieldset>
                    <legend>Cliente</legend>
                  <div class="form-group">
                    <label for="dniCliente" class="col-sm-2 control-label">DNI</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="dniCliente" id="dniCliente" onchange="onchangeDniCliente()">
                      <input type="hidden" name="idCliente" id="idCliente">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="nombreCliente" class="col-sm-2 control-label">Cliente</label>
                    <div class="col-sm-6">
                      <input type="text" class="form-control" id="nombreCliente" name="nombreCliente">
                    </div>
                  </div>
                </fieldset>
                    
                <fieldset>

                    <legend>Importe Total</legend>
                   <div class="form-group">
                    <div class="col-sm-2">
                        <input type="text" readonly="readonly" class="form-control" name="montoTotal" id="montoTotal" value="${proforma.inportePorforma}">
                    </div>
                  </div>
                </fieldset>
                <br/>
                <fieldset>
                    <legend></legend>
                    <div class="form-group">

                        <div class="col-sm-2">
                            <button type="submit" class="btn btn-primary">Emitir Boleta</button>
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

function onchangeDniCliente(){
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