<link href="../jquery/jquery-ui.css" rel="stylesheet" media="screen">
<!-- Bootstrap -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- styles -->
<link href="../css/styles.css" rel="stylesheet">
<link href="../css/forms.css" rel="stylesheet">
    <div class="content-box-large">

        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <fieldset>
                    <legend>Agregar Producto</legend>
                  <div class="form-group">
                    <label for="nombreProducto" class="col-sm-2 control-label">Producto</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="nombreProducto" id="nombreProducto">
                        <input type="hidden" name="idProducto" id="idProducto"/>  
                    </div>
                    <div class="col-sm-2">
                        <input type=button class="btn btn-success btn-sm" onclick="seleccionarProductoPrincipal()" value="Seleccionar"> 
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="cantidadProducto" class="col-sm-2 control-label">Cantidad</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" value="1" name="cantidadProducto" id="cantidadProducto">
                    </div>
                  </div>
                </fieldset>
                
                
                <div>
                    <h4>Detalle Producto</h4>
                    <p>
                        <table id="user" class="table table-bordered table-striped" style="clear: both">
                            <tbody> 
                                <tr>         
                                    <td width="35%">Nombre</td>
                                    <td width="65%" id="nombreTD"></td>
                                </tr>
                                <tr>         
                                    <td>Receta</td>
                                    <td id="recetaTD"></td>
                                </tr>  
                                <tr>         
                                    <td>Precio</td>
                                    <td id="precioTD"></td>
                                </tr>
                                <tr>         
                                    <td>Stock</td>
                                    <td id="stockTD"></td>
                                </tr> 
                                <tr>         
                                    <td>Descripcion</td>
                                    <td id="descripcionTD"></td>
                                </tr>
                            </tbody>
                        </table>
                    </p>
                </div>

                <fieldset>
                    <legend>Productos Similares</legend>
                    <table class="table table-condensed" id="tableProductosSimilares">
                        <tr>
                            <th style="width: 250px;">Nombre</th>
                            <th style="width: 50px;">Receta</th>
                            <th style="width: 50px;">Precio</th>
                            <th style="width: 50px;">Stock</th>
                            <th style="width: 350px;">Descripcion</th>
                            <th style="width: 50px;"></th>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </div>

<script src="../jquery/jquery.js"></script>
<!-- jQuery UI -->
<script src="../jquery/jquery-ui.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
    
<script type="text/javascript">
$( function() {
    $("#nombreProducto").autocomplete({
        source : function(request, response) {
        $.ajax({
                url : "autocompletarProducto",
                type : "GET",
                data : {
                        nombreProducto : $("#nombreProducto").val()
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
            $("#idProducto").val(ui.item.id);
            $("#nombreTD").html(ui.item.nombre);
            $("#recetaTD").html(ui.item.receta);
            $("#precioTD").html(ui.item.precio);
            $("#descripcionTD").html(ui.item.descripcion);
            $("#stockTD").html(ui.item.stock);
            var productosRelacionados = ui.item.similares; 
            obtenerProductosRelacionados(productosRelacionados);
        }
    });
} );

function obtenerProductosRelacionados(productos){
    var cant_borrar = document.getElementById("tableProductosSimilares").rows.length - 1;
    if(cant_borrar > 0){
        for(var i=0; i<cant_borrar; i++) {
            document.getElementById("tableProductosSimilares").deleteRow(1);
        }
    }
    for(var i=0; i<productos.length; i++) {
        var filas = document.getElementById("tableProductosSimilares").rows.length;
        var x = document.getElementById("tableProductosSimilares").insertRow(filas);

        var col1 = x.insertCell(0);
        var col2 = x.insertCell(1);
        var col3 = x.insertCell(2);
        var col4 = x.insertCell(3);
        var col5 = x.insertCell(4);
        var col6 = x.insertCell(5);
    
        col1.innerHTML = productos[i].nombre;
        col2.innerHTML = productos[i].receta;
        col3.innerHTML = productos[i].precio;
        col4.innerHTML = productos[i].stock;
        col5.innerHTML = productos[i].descripcion;
        col6.innerHTML = " <input type=button class=\"btn btn-success btn-sm\" onclick=\"seleccionarProductoSimilar(" + productos[i].id + ", '" + productos[i].nombre + "' ," + productos[i].stock + ", " + productos[i].precio + ")\" value='Seleccionar'> ";

    }

}
function seleccionarProductoPrincipal() { 
  var idProducto = $("#idProducto").val();
  var stock = parseInt($("#stockTD").html());
  var cantidad = parseInt($("#cantidadProducto").val());

  if(idProducto === null || idProducto === ""){
      alert("Primero Seleccione un Producto");
      return false;
  }
  if(stock === "0" || stock <= 0 || cantidad > stock){
      alert("No hay Stock Suficiente");
      return false;
  }

  agregarDetalleProforma(idProducto, $("#nombreTD").html(), cantidad, Number($("#precioTD").html()));

} 
function seleccionarProductoSimilar(idProducto, nombreProducto ,stock, precio) { 
    var cantidad = $("#cantidadProducto").val();

    if(idProducto === null || idProducto === ""){
        alert("Primero Seleccione un Producto");
        return false;
    }
    if(stock === "0" || stock <= 0 || cantidad > stock){
        alert("No hay Stock Suficiente");
        return false;
    }

    agregarDetalleProforma(idProducto, nombreProducto, cantidad, precio);

} 

function agregarDetalleProforma(idProducto, nombreProducto, cantidad, precio){
    var filas = window.opener.document.getElementById("tableDetalleProforma").rows.length;
    var x = window.opener.document.getElementById("tableDetalleProforma").insertRow(filas);

    var col1 = x.insertCell(0);
    var col2 = x.insertCell(1);
    var col3 = x.insertCell(2);
    var col4 = x.insertCell(3);
    var col5 = x.insertCell(4);


    col1.innerHTML = nombreProducto + '<input type="hidden" readonly="readonly"  value="' + nombreProducto + '" /> <input type="hidden" name="detalleIdProducto" value="' + idProducto + '" />';
    col2.innerHTML = cantidad + '<input type="hidden" name="detalleCantidad" readonly="readonly"  value="' + cantidad + '" />';
    col3.innerHTML = precio + '<input type="hidden" name="detallePrecio" readonly="readonly"  value="' + precio + '" />';
    col4.innerHTML = precio * cantidad + '<input type="hidden" name="detallePrecioTotal" readonly="readonly"  value="' + precio * cantidad + '" />';
    col5.innerHTML = '<input type="button" class="btn btn-danger btn-sm" value="Eliminar" />';
    
    var montoTotal = 0;
    var fields = window.opener.document.getElementsByName("detallePrecioTotal");
    for(var i = 0; i < fields.length; i++) {
        montoTotal += Number(fields[i].value);
    }
    window.opener.document.getElementById("montoTotal").value = montoTotal;
    window.close();
}
</script> 