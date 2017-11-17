<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="../WEB-INF/libreria.tld" prefix="libreria"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agencia de Viajes CVP S.A</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h2></h2>

	<div class="container" align="center">
		<div class="media-body">
			<h4 class="media-heading"></h4>

			<div class="col-sm-8">
				<div class="row">
					<div class="col-sm-10">
						<div class="panel panel-primary">
							<div class="panel-heading" align="center">
								<h3 class="panel-title">Consultar Buses por Estado</h3>
							</div>
							<div class="panel-body">

								<form action="">

									<input type="hidden" value="listarBuses" name="operacion">

									<div class="padre">
										<div class="hijo">
											<label>Estado de los buses:</label>
										</div>
									</div>


									<div class="padre">
										<div class="hijo" id="caja">
											<select name="cboEstadoBus" class="datos">
												<libreria:EstadoBuses />
											</select>
										</div>
									</div>
									<br>

									<div class="padre">
										<div class="hijo" id="boton">
											<input type="submit" class="btn btn-info" name="btnConsultar"
												value="Ver lista" class="botones" onclick=this.form.action="BusServlet">
										</div>
									</div>

								</form>

								<hr>
								<display:table name="${listadoBuses}"
									decorator="com.cvpsa.appagenciaviajes.business.decorator.Wrapper">
									<display:column title="Código" property="codBus"></display:column>
									<display:column title="Placa" property="placaBus"></display:column>
									<display:column title="Color" property="colorBus"></display:column>
									<display:column title="Marca" property="marcaBus"></display:column>
									<display:column title="Cant. asient." property="asientoBus"></display:column>
									<display:column title="Estado" property="estadoBusWrapper"></display:column>
								</display:table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>