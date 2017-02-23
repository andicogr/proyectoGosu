
<%@page import="com.pe.grupoads.beans.detalleProformaBeans"%>
<%@page import="com.pe.grupoads.DAO.proformaDAO"%>
<%@page import="com.pe.grupoads.beans.proformaBeans"%>
<%@page import="java.util.ArrayList"%>
<script src="jquery/jquery.js"></script>

    <div class="content-box-large">

        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <fieldset>
                    <legend>Proformas Emitidas</legend>
                    <table class="table table-condensed" id="tableDetalleProforma">
                        <tr>
                            <th style="width: 100px">Proforma</th>
                            <th style="width: 150px">Detalle / Cantidad</th>
                            <th style="width: 100px">Monto Total</th>
                            <th style="width: 100px"></th>
                        </tr>
                        <% ArrayList<proformaBeans> listaProformas = proformaDAO.obtenerProformasPendientes(); 
                            for(proformaBeans x : listaProformas){
                        %>  
                        <tr>
                            <th><%="Proforma-" + x.getCodProforma() %></th>

                            <th><%for(detalleProformaBeans y: x.getDetalle()){ %>
                                   <%=y.getNombreProducto() + " / " + y.getCantidad() %> <br/>
                                 <%}%>
                            </th>
                            <th><%=x.getInportePorforma() %></th>
                            <th>
                                <a href="pagarProforma?idProforma=<%=x.getCodProforma() %>" class="btn btn-success" role="button">Pagar</a>
                                <a href="anularProforma?idProforma=<%=x.getCodProforma() %>" onclick="return confirm('Esta seguro de anular la proforma?')" class="btn btn-danger" role="button">Anular</a>
                            </th>
                        </tr>
                        <%}%>
                        
                    </table>

                </fieldset>


            </form>
        </div>
    </div>

<script type="text/javascript">
$( function() {


} );

function onchangeDniCliente(){

}


</script>