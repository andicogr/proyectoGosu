           
<script src="jquery/jquery.js"></script>

    <div class="content-box-large">

        <div class="panel-body">
            <form class="form-horizontal" role="form" id="formularioStock" onsubmit="return validarFormulario();" action="actualizarproducto">
                <fieldset>
                    <legend>Actualizar Stock</legend>
                    <div class="form-group">
                        <label for="nombreProducto" class="col-sm-2 control-label">Producto</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="nombreProducto" id="nombreProducto">
                            <input type="hidden" class="form-control" name="selecproducto" id="selecproducto">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtCantidad" class="col-sm-2 control-label">Cantidad</label>
                        <div class="col-sm-1">
                            <input type="text" class="form-control" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="txtCantidad" id="txtCantidad">
                        </div>
                    </div>				
                </fieldset>
                <br/>
                <fieldset>
                    <legend></legend>
                    <div class="form-group">

                        <div class="col-sm-2">
                            <button type="submit" class="btn btn-primary">Actualizar Stock</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>

<script type="text/javascript">
$( function() {
    $("#nombreProducto").autocomplete({
        source : function(request, response) {
        $.ajax({
                url : "autocompletarProductoStock",
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
            $("#selecproducto").val(ui.item.id);
            
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
    var x = document.forms["formularioStock"]["selecproducto"].value;
    if(x === ""){
        alert("Seleccione un producto valido");
        return false;
    }
    
    var y = document.forms["formularioStock"]["txtCantidad"].value;
    if(y === ""){
        alert("Ingrese una cantidad");
        return false;
    }
    
}
</script>