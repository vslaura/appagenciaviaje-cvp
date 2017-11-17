<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="../WEB-INF/libreria.tld" prefix="libreria"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet"
	href="/vendor/bootstrap-combobox/css/bootstrap-combobox.css">
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/RegistrarCliente.js"></script>
        
<title>Agencia de Viajes CVP S.A</title>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-4">
			<h4>|| Datos personales ||</h4>
			<hr />

			<form role="form" method="post" action="register" onkeypress="return validarDatos(event)">

				<input type="hidden" value="registrarCliente" name="operacion">

				<!-- 				<label for="text">Código</label> -->
				<div class="form-group">

					<input type="hidden" value='<libreria:generarCodigoCliente/>'
						class="form-control" name="txtCodigoCli" placeholder="Código"
						readonly="readonly">
				</div>
				<div class="form-group">
					<label for="text">Dni</label> <input type="text"
						class="form-control" name="txtDniCli" size="30" maxlength="8" class="input" onkeypress="return soloNumeros(event)" required="required"
						placeholder="Ejem: 763615..">
				</div>
				<div class="form-group">
					<label for="text">Nombres</label> <input type="text"
						class="form-control" name="txtNombreCli"   size="30" maxlength="50"  onkeypress="return soloLetras(event)" required="required"
						placeholder="Ejem: Laura">
				</div>

				<div class="form-group">
					<label>Apellidos</label> <input type="text" class="form-control"
						name="txtApeCli" size="30" maxlength="50"  onkeypress="return soloLetras(event)"   required="required"
						placeholder="Ejem: Valdivia Sanchez">
				</div>



				<div class="form-group">
					<label>E-mail</label> <input type="email" class="form-control"
						name="txtEmailCli" size="30" maxlength="50" required="required"
						placeholder="Ejem: lcvaldivia@gmai.com">
				</div>
				<br>
				<h4>|| Pago con Tarjeta ||</h4>
				<hr>



				<div class="form-group">
					<label>Nro. de Cuenta</label> <input type="text"
						class="form-control" name="txtCuenta" size="30" maxlength="16" onkeypress="return soloNumeros(event)" required="required"
						placeholder="Ejem: 4444888855556666">
				</div>

				<div class="form-group">
					<label>Fec. Vcto</label> <input type="text" class="form-control"
						name="txtFechaVencimiento"  onkeypress="return soloNumeros(event)" required="required"
						placeholder="Ejem: 12/22">
				</div>


				<div class="form-group">
					<label>CVV</label> <input type="text"
						class="form-control" name="txtDigitos"  maxlength="3" onkeypress="return soloNumeros(event)" required="required"
						placeholder="Ejem: 666">
				</div>

				<button type="submit" class="btn btn-info btn-block"
					onclick=this.form.action="ClienteServlet" >Comprar</button>
			</form>
		</div>
	</div>
	<br>
	<br>

</body>
</html>