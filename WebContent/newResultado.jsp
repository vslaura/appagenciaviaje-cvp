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
	<link rel="stylesheet" href="css/newBodyResultado.css" />
	<link rel="stylesheet" href="css/newInformacion.css">
	<link rel="stylesheet" href="css/newFooter.css" />

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
				<h2>${param.msjTitulo}</h2>
				<br>
				<h3>${param.msjNombre}</h3>
				<br>
				<h3>${param.msjPrimeraLinea}</h3>
				<h3>${param.msjSegundaLinea}</h3>
				<br>
				<a href="newIndex.jsp"><input class="boton_personalizado" type="button" value="Regresar a la página principal"></a>
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
