    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<script src="jquery/jquery.js"></script>

    <div class="content-box-large">

        <div class="panel-body">
            <form class="form-horizontal" role="form" action="registrarProforma">
                <fieldset>
                    <legend>Proforma</legend>
                  <div class="form-group">
                    <label for="fechaProforma" class="col-sm-2 control-label">Fecha</label>
                    <div class="col-sm-2">
                        <% Date today = new Date(); 
                            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                       %>
                       <input type="text" readonly="readonly" class="form-control" name="fechaProforma" id="fechaProforma" value="<%=dateFormat.format(today)%>">
                    </div>
                    <div class="col-sm-6">
                    </div>
                    <div class="col-sm-2">
                      <a href="inicio.jsp?op=vender_producto" onclick="return confirm('Esta seguro de anular la proforma?')" class="btn btn-danger" role="button">Anular</a>
                    </div>
                  </div>
                </fieldset>

                    
                <fieldset>

                    <legend>Detalle Proforma</legend>
                    <p>
                        <input type="button" class="btn btn-default" onclick="buscarProducto()" value="Agregar Producto"/>
                    </p>
                    <table class="table table-condensed" id="tableDetalleProforma">
                        <tr>
                            <th style="width: 250px">Producto</th>
                            <th style="width: 100px">Cantidad</th>
                            <th style="width: 150px">Precio Unitario S/</th>
                            <th style="width: 150px">Precio Total S/</th>
                            <th style="width: 100px"></th>
                        </tr>
                    </table>
                  <div class="form-group">
                    <div class="col-sm-6">

                    </div>
                    <label for="montoTotal" class="col-sm-2 control-label">Monto Total</label>
                    <div class="col-sm-2">
                        <input type="text" readonly="readonly" class="form-control" name="montoTotal" id="montoTotal" value="0.00">
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

<script type="text/javascript">
$( function() {
    $('#tableDetalleProforma').on('click', 'input[type="button"]', function () {
        $(this).closest('tr').remove();
        var montoTotal = 0;
        var fields = document.getElementsByName("detallePrecioTotal");
        for(var i = 0; i < fields.length; i++) {
            montoTotal += Number(fields[i].value);
        }
        $("#montoTotal").val(montoTotal);
    });
    
$(document).ready(function() {
  $(window).keydown(function(event){
    if(event.keyCode == 13) {
      event.preventDefault();
      return false;
    }
  });
});


} );

function buscarProducto(){
    window.open("abrirFormularioBuscarProducto","_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=10,left=450,width=800,height=700");
}
</script>