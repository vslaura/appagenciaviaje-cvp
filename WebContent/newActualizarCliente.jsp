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
	<link rel="stylesheet" href="css/newPerfilCliente.css">
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
				<h2>Actualizar </h2>

				<div class="cuerpo-formulario">
					<form action="">

						<input type="hidden" value="modificarCliente" name="operacion">
						<input type="hidden" value="${usuarioSession.getCodCli()}" name="txtCodigoCliente">

						<table>

							<tr>

								<td colspan="4"><span>Mis datos</span>
									<hr> </td>
							</tr>
							<tr>
								<td><label for="">DNI:</label></td>																									
								<td><input type="text" name="txtDNI" value="${usuarioSession.getDniCli()}" readonly="readonly"></td>
								<td><label for="">Nombres:</label></td>
								<td><input type="text" name="txtNombres" onkeypress="return soloLetras(event)" required="required" placeholder="Laura" maxlength="30" value= "${usuarioSession.getNomCli()}"></td>
							</tr>
							<tr>
								<td><label for="">Apellidos:</label></td>
								<td><input type="text" name="txtApellidos" onkeypress="return soloLetras(event)" required="required" placeholder="Valdivia S�nchez" value= "${usuarioSession.getApeCli()}"></td>

								<td><label for="">E-mail:</label></td>
								<td><input type="email" name="txtEmail" required="required" placeholder="miCorreo@gmail.com" maxlength="50" value= "${usuarioSession.getEmailCli()}" ></td>
							</tr>
							<tr>
								<td><label for="">Usuario:</label></td>

								<td><input type="text" name="txtUsuario" required="required" placeholder="laura456" maxlength="20" minlength="4"  value= "${usuarioSession.getUsuarioCli()}" ></td>
								<td><label for="">Clave:</label></td>
								<td><input type="password" name="txtClave" required="required" placeholder="miClave" maxlength="20" minlength="4" value= "${usuarioSession.getClaveCli()}" ></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td colspan="4" style="text-align: center;"><input type="submit" class="btn" value="Grabar" onclick=this.form.action="ClienteServlet">
									<a href="newIndex.jsp"><input type="button" value="Salir" class="btn"></a>
								</td>
							</tr>

						</table>
					</form>
				</div>

			</div>




		</section>

		<section id="cuerpo-informacion">
			<h3>M�s de nuestros destinos</h3>
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
