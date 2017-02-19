<!DOCTYPE html>
<html>
  <head>
    <title>Farmacia</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- jQuery UI -->
    <link href="jquery/jquery-ui.css" rel="stylesheet" media="screen">

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- styles -->
    <link href="css/styles.css" rel="stylesheet">


    <link href="vendors/form-helpers/css/bootstrap-formhelpers.min.css" rel="stylesheet">
    <link href="vendors/select/bootstrap-select.min.css" rel="stylesheet">
    <link href="vendors/tags/css/bootstrap-tags.css" rel="stylesheet">

    <link href="css/forms.css" rel="stylesheet">


  </head>
  <body>
  	<div class="header">
	     <div class="container">
	        <div class="row">
	           <div class="col-md-5">
	              <!-- Logo -->
	              <div class="logo">
	                 <h1><a href="#">Farmacia de Raul El Papi</a></h1>
	              </div>
	           </div>
	           <div class="col-md-5">
	              <div class="row">
	                <div class="col-lg-12">
	                  <div class="input-group form">

	                  </div>
	                </div>
	              </div>
	           </div>
	           <div class="col-md-2">
	              <div class="navbar navbar-inverse" role="banner">
	                  <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
	                    <ul class="nav navbar-nav">
	                      <li class="dropdown">
	                        <a href="cerrarSession" >Cerrar Sesion </a>
	                        <!--ul class="dropdown-menu animated fadeInUp">
	                          <li><a href="profile.html">Profile</a></li>
	                          <li><a href="login.html">Logout</a></li>
	                        </ul-->
	                      </li>
	                    </ul>
	                  </nav>
	              </div>
	           </div>
	        </div>
	     </div>
	</div>

    <div class="page-content">
    	<div class="row">
            <div class="col-md-2">
            <div class="sidebar content-box" style="display: block;">
                <ul class="nav">
                    <% String nombrePrivilegio = ""; %>
                    <%if(session.getAttribute("privilegio") !=null){ %>
                    <% nombrePrivilegio = (String)request.getSession().getAttribute("privilegio"); %> 
                    <%}%>
                    <%if(nombrePrivilegio.equals("administrador")){ %>
                        <li class="submenu">
                             <a href="#">
                                <i class="glyphicon glyphicon-user"></i> Usuarios
                                <span class="caret pull-right"></span>
                             </a>
                             <!-- Sub menu -->
                             <ul>
                                <li><a href="inicio.jsp?op=agregaruser">Agregar Usuarios</a></li>
                                <li><a href="listar">Listar Usuarios</a></li>
                            </ul>
                        </li>
                    <%}%>
                    <%if(nombrePrivilegio.equals("administrador")){ %>
                    <li> <a href="#">Registrar Producto</a></li>
                    <%}%>
                    <%if(nombrePrivilegio.equals("administrador") || nombrePrivilegio.equals("ventas")){ %>
                    <li> <a href="inicio.jsp?op=vender_producto">Ventas</a></li>
                    <%}%>
                    <%if(nombrePrivilegio.equals("administrador") || nombrePrivilegio.equals("cajero")){ %>
                    <li> <a href="inicio.jsp?op=cajero">Caja</a></li>
                    <%}%>
       

                </ul>
             </div>
		  </div>
		  <div class="col-md-10">
                        <%if(session.getAttribute("IDusuario") !=null){ %>

                        <%String op=(String)request.getParameter("op");%>

                         <%if(op!=null){%>
                                    <%if(op.equals("operaciones")){%>
                                    <%@include file="administrador/operaciones.jsp" %>

                                    <%}%>
                                    <%if(op.equals("agregaruser")){%>
                                    <%@include file="administrador/nuevousuario.jsp" %>

                                    <%}%>
                                    <%if(op.equals("listaruser")){%>
                                    <%@include file="administrador/listarusuarios.jsp" %>

                                    <%}%>
                                    <%if(op.equals("editaruser")){%>
                                    <%@include file="administrador/editarusuario.jsp" %>

                                    <%}%>

                                    <%if(op.equals("vender_producto")){%>
                                    <%@include file="ventas/formularioBoleta.jsp" %>

                                    <%}%>
                                    
                                    <%if(op.equals("cajero")){%>
                                    <%@include file="cajero/listaProformaPendientes.jsp" %>

                                    <%}%>
                                    
                                    <%if(op.equals("pagar_proforma")){%>
                                    <%@include file="cajero/formularioPagarProforma.jsp" %>

                                    <%}%>

                                    <%}else{%>
                                     <%@include file="prueba.jsp" %>
                            <%}%>

                        <%}else{%>
                             <%@include file="sesionExpirada.jsp" %>
                        <%}%>

	  		<!--  Page content -->
		  </div>
		</div>
    </div>

    <footer>
         <div class="container">
         
            <div class="copy text-center">
               Copyright 2014 <a href='#'>Website</a>
            </div>
            
         </div>
      </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery/jquery.js"></script>
    <!-- jQuery UI -->
    <script src="jquery/jquery-ui.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <script src="vendors/form-helpers/js/bootstrap-formhelpers.min.js"></script>

    <script src="vendors/select/bootstrap-select.min.js"></script>

    <script src="vendors/tags/js/bootstrap-tags.min.js"></script>

    <script src="vendors/mask/jquery.maskedinput.min.js"></script>

    <script src="vendors/moment/moment.min.js"></script>

    <script src="vendors/wizard/jquery.bootstrap.wizard.min.js"></script>

     <!-- bootstrap-datetimepicker -->
     <link href="vendors/bootstrap-datetimepicker/datetimepicker.css" rel="stylesheet">
     <script src="vendors/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script> 


    <link href="css/bootstrap-editable.css" rel="stylesheet"/>
    <script src="js/bootstrap-editable.min.js"></script>

    <script src="js/custom.js"></script>
    <script src="js/forms.js"></script>
  </body>
</html>