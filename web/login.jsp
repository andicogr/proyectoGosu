
<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap Admin Theme v3</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- styles -->
    <link href="css/styles.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">

  </head>
  <body class="login-bg">

    <form id="frmlogin" method="post" action="logearUsuario" name="frmlogin">
	<div class="page-content container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-wrapper">
			        <div class="box">
			            <div class="content-wrap">
			                <h6>Ingreso</h6>

			                <input class="form-control" type="text" name="txtusuario" placeholder="Usuario">
			                <input class="form-control" type="password" name="txtpassword" placeholder="Clave">
			                <div class="action">
                                            <button class="btn btn-primary signup">Ingresar</button>
			                </div>                
			            </div>
			        </div>

			        <div class="already">
			            <%if(session.getAttribute("mensaje") !=null){ %>
                                    <%=(String)request.getSession().getAttribute("mensaje") %> 
                                    <%}%>
			        </div>
			    </div>
			</div>
		</div>
	</div>
    </form>



    <script src="jquery/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/custom.js"></script>
  </body>
</html>