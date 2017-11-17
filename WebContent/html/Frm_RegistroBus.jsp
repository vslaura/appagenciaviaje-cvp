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

<title>Agencia de Viajes CVP S.A</title>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-3 col-md-6">
			<h3>Registro de Bus</h3>
			<hr />

			<form role="form" method="post" action="register">

				<input type="hidden" value="registrarBuses" name="operacion">

				<div class="form-group">
					<label for="username">Código</label> <input type="text" value='<libreria:generarCodigoBus/>'
						class="form-control" name="txtCodigo" placeholder="Código"
						readonly="readonly">
				</div>
				<div class="form-group">
					<label for="email">Placa</label> <input type="text"
						class="form-control" name="txtPlaca"
						placeholder="Introduce el nro Placa">
				</div>
				<div class="form-group">
					<label for="password">Color</label> <input type="text"
						class="form-control" name="txtColor"
						placeholder="Introduce en color">
				</div>

				<div class="form-group">
					<label>Marca</label> <input type="text" class="form-control"
						name="txtMarca" placeholder="Introduce la marca">
				</div>


				<div class="form-group">
					<label>Nro Asiento</label> <input type="number"
						class="form-control" name="txtCantidadAsientosBus"
						placeholder="Introduce el Nro de Asiento">
				</div>

				<div class="form-group">
					<label class="col-xs-3 control-label">Estado</label>
					<div class="col-xs-5 selectContainer">
						<select class="form-control" name="cboEstadoBus">
							<libreria:EstadoBuses />
						</select>
						<br>
					</div>
				</div>


				<br> <br>

				<button type="submit" class="btn btn-info btn-block" onclick=this.form.action="BusServlet">Registro</button>
			</form>
		</div>
	</div>

</body>
</html>