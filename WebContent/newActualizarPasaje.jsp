<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="../WEB-INF/libreria.tld" prefix="libreria"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">

<head>
	<title>:: Agencia de viajes C.V.P ::</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1">

	<link rel="shortcut icon" href="imagenes/viajes.ico" />	
	
	<link rel="stylesheet" href="css/newStyle.css" />
	<link rel="stylesheet" href="css/newHeader.css" />
	<link rel="stylesheet" href="css/newMenu.css">
	<link rel="stylesheet" href="css/newBodyPasaje.css">
	<link rel="stylesheet" href="css/newInformacion.css">
	<link rel="stylesheet" href="css/newFooter.css" />
	
	<script type="text/javascript" src="js/ValidacionCampos.js"></script>

</head>

<body>

	<header>
		<div class="contenedor">
			<h1>Agencia de viajes C.V.P</h1>
			<nav class="menu">
				<a href="newIndex.jsp">Inicio</a>
				<a href="#">Quienes somos</a>
				<c:if test="${usuarioSession != null }">
					<div class="dropdown">
						<a href="#" class="dropbtn">${usuarioSession.getNomCli()}</a>
						<div class="dropdown-content">
							<a href="newPerfilCliente.jsp">Mi Perfil</a>
							 <a href="PasajeServlet?operacion=listarPasajeCliente">Mis reservas</a> 
							 <a href="ClienteServlet?operacion=salir">Salir</a>
						</div>
					</div>
				</c:if>
				<c:if test="${ usuarioSession == null }">
					<a href="newLogin.jsp">Acceso</a>
				</c:if>
			</nav>
		</div>
	</header>
	<main>

		<section id="cuerpo-titulo">
			<div class="contenedor">
				<h2>Actualizar su pasaje</h2>

				<div class="cuerpo-formulario">
					<form action="">
					
					<input type="hidden" value="registrarCliente" name="operacion">
					<input type="hidden" value='<libreria:generarCodigoCliente/>' name="txtCodigoCliente">
					<input type="hidden" value=${param.codigoViaje} name="txtCodigoViaje">
					
						<table>
							<tr>
								<td colspan="6"><span>Datos del pasaje</span>
									<hr>
								</td>
							</tr>
							<tr>
								<td><label for="">Origen: </label></td>
								<td><input type="text" value=${param.origen} name="txtOrigen" readonly="readonly"></td>
								<td><label for="">Destino: </label></td>
								<td><input type="text" value=${param.destino} name="txtDestino" readonly="readonly"></td>
								<td><label for="">Fecha de viaje: </label></td>
								<td><input type="text" value=${param.fechaDestino} name="dtFechaViaje" readonly="readonly"></td>
							</tr>
							<tr>
								<td><label for="">Nro. asiento: </label></td>
								<td><select name="cboAsiento" id=""><option value="1">1</option><option value="">2</option></select></td>
								<td><label for="">Precio: </label></td>
								<td><input type="text" name="txtPrecio" onkeypress="return soloDecimales(event)" required="required" placeholder="50.00"></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td colspan="6"  style="text-align: center;"><input type="submit" class="btn" value="Grabar" onclick=this.form.action="ClienteServlet">
								<a href="newReservaViajesCliente.jsp"><input type="button" value="Salir" class="btn"></a>
								</td>
							</tr>

						</table>
					</form>
				</div>

			</div>




		</section>

		<section id="cuerpo-informacion">
			<h3>Más de nuestros destinos</h3>
			<div class="contenedor">
				<div>
					<img src="imagenes/index/img1.jpg" />
					<h4>Comentario</h4>
				</div>
				<div>
					<img src="imagenes/index/img1.jpg" />
					<h4>Comentario</h4>
				</div>
				<div>
					<img src="imagenes/index/img1.jpg" />
					<h4>Comentario</h4>
				</div>
				<div>
					<img src="imagenes/index/img1.jpg" />
					<h4>Comentario</h4>
				</div>
			</div>

		</section>

	</main>

	<footer class="contenedor">
		<p class="copy">Agencia de viajes C.V.P &copy; 2017</p>
		<div class="sociales">
			<a class="icon-facebook-squared" href="#"></a>
			<a class="icon-twitter-squared" href="#"></a>
			<a class="icon-gmail-squared" href="#"></a>
		</div>
	</footer>

	<script src="js/newJquery-min.js"></script>
	<script src="js/newSlider.js"></script>

</body>

</html>
