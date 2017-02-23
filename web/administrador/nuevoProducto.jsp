            
<script src="jquery/jquery.js"></script>

    <div class="content-box-large">

        <div class="panel-body">
            <form class="form-horizontal" role="form" id="formularioRegistrarProducto" onsubmit="return validarFormulario();" action="registrarProductoServlet">
                <fieldset>
                    <legend>Nuevo Producto</legend>
                    <div class="form-group">
                        <label for="nombreProducto" class="col-sm-2 control-label">Nombre</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" required="true" name="nombreProducto" id="nombreProducto">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="precioVenta" class="col-sm-2 control-label">Precio Venta</label>
                        <div class="col-sm-1">
                            <input type="text" class="form-control" required="true" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="precioVenta" id="precioVenta">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stockInicial" class="col-sm-2 control-label">Stock Inicial</label>
                        <div class="col-sm-1">
                            <input type="text" class="form-control" required="true" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="stockInicial" id="stockInicial">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="receta" class="col-sm-2 control-label">Receta</label>
                        <div class="col-sm-1">
                            <select name="receta" id="receta" class="form-control" id="select-1">
                                <option value="si">Si</option>
                                <option value="no">No</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="descripcion" class="col-sm-2 control-label">Descripcion</label>
                        <div class="col-sm-6">
                            <textarea class="form-control" name="descripcion" required="true" id="descripcion" rows="5"></textarea>
                        </div>
                    </div>				
                </fieldset>

                <fieldset>
                    <legend>Componentes</legend>
                    <div class="form-group">
                        <label for="nombreComponente" class="col-sm-1 control-label">Componente</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="nombreComponente" id="nombreComponente">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8">
                            <table class="table table-condensed" id="tableListaComponentes">
                                <tr>
                                    <th style="width: 250px">Componente</th>
                                    <th style="width: 100px">Concentracion</th>
                                    <th style="width: 100px">Unidad</th>
                                    <th style="width: 100px">Eliminar</th>
                                </tr>
                            </table>
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
    $('#tableListaComponentes').on('click', 'input[type="button"]', function () {
        $(this).closest('tr').remove();
    });

    $("#nombreComponente").autocomplete({
        source : function(request, response) {
        $.ajax({
                url : "autocompletarComponente",
                type : "GET",
                data : {
                        nombreComponente : $("#nombreComponente").val()
                },
                dataType : "json",
                success : function(data) {
                    var items = data;
                    response(items);
                }
             });
            },
        minLength: 2,
        select: function( event, ui ) {
            $("#nombreComponente").val("");
            agregarComponente(ui.item.id, ui.item.nombre, ui.item.concentracion, ui.item.unidad);
            
        }
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

function validarFormulario(){
    var values = [];
    $("input[name='idComponentes']").each(function() {
        values.push($(this).val());
    });
    if(values.length === 0){
        alert("Debe registrar al menos un componente");
        return false;
    }
}
function agregarComponente(idComponente, nombre, concentracion, unidad){

    var filas = document.getElementById("tableListaComponentes").rows.length;
    var x = document.getElementById("tableListaComponentes").insertRow(filas);

    var col1 = x.insertCell(0);
    var col2 = x.insertCell(1);
    var col3 = x.insertCell(2);
    var col4 = x.insertCell(3);


    col1.innerHTML = " <input type='hidden' name='idComponentes' id='idComponentes' value='" + idComponente + "'> " + nombre;
    col2.innerHTML = concentracion;
    col3.innerHTML = unidad;
    col4.innerHTML = '<input type="button" class="btn btn-danger btn-sm" value="Eliminar" />';


}
</script>