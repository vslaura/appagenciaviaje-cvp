<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="../WEB-INF/libreria.tld" prefix="libreria"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">

<head>
<title>:: Agencia de Viaje C.V.P ::</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1">

<link rel="shortcut icon" href="imagenes/viajes.ico" />

<link rel="stylesheet" href="css/newStyle.css">
<link rel="stylesheet" href="css/newHeader.css">
<link rel="stylesheet" href="css/newMenu.css">
<link rel="stylesheet" href="css/newSlider.css">
<link rel="stylesheet" href="css/newBody.css">
<link rel="stylesheet" href="css/newFooter.css" />
<link rel="stylesheet" href="css/newInformacion.css">

</head>

<body>
	<header>
		<div class="contenedor">
			<h1>Agencia de viaje C.V.P</h1>
			<nav class="menu">
				<a href="#">Inicio</a> <a href="#">Quienes somos</a>
				<c:if test="${usuarioSession != null }">
					<div class="dropdown">
						<a href="#" class="dropbtn">${usuarioSession.getNomCli()}</a>
						<div class="dropdown-content">
							<a href="newPerfilCliente.jsp">Mi Perfil</a>
							<a href="">Mis reservas</a>
							<a href="">Salir</a>
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
	<section>
		<div class="contenedor-slider" id="contenedor-slider">
			<div class="slider" id="slider">
				<section class="slider__section">
					<img class="slider__img" src="imagenes/index/banner.jpg" />
				</section>
				<section class="slider__section">
					<img class="slider__img" src="imagenes/index/banner.jpg" />
				</section>
				<section class="slider__section">
					<img class="slider__img" src="imagenes/index/banner.jpg" />
				</section>
				<section class="slider__section">
					<img class="slider__img" src="imagenes/index/banner.jpg" />
				</section>
			</div>
			<div class="btn-prev" id="btn-prev">&#61;</div>
			<div class="btn-next" id="btn-next">&#61;</div>

		</div>
	</section>

	<section id="cuerpo-titulo">
		<div class="contenedor">
			<h2>Reserva de pasajes</h2>
			<div class="menu-viaje">
				<form action="">
					<input type="hidden" value="listarViajesPorOrigenDestinoFecha"
						name="operacion"> <label>Origen:</label> <select
						class="combo" name="cboDepartamentoPartida">
						<libreria:Departamento />
					</select> <label>Destino</label> <select class="combo"
						name="cboDepartamentoLlegada">
						<libreria:Departamento />
					</select> <label>Fecha de salida:</label> <input class="fecha" type="date"
						name="dtFechaSalida" />
					<p>
						<input class="boton_personalizado" type="submit" value="Buscar"
							onclick=this.form.action="ViajeServlet">
					</p>
				</form>

			</div>
		</div>

	</section>

	<section id="cuerpo-principal">
		<h3>Algunos de nuestros destinos</h3>
		<div class="contenedor">
			<article>
				<img src="imagenes/index/img1.jpg" />
				<h4>Comentario</h4>
			</article>
			<article>
				<img src="imagenes/index/img1.jpg" />
				<h4>Comentario</h4>
			</article>
			<article>
				<img src="imagenes/index/img1.jpg" />
				<h4>Comentario</h4>
			</article>
			<article>
				<img src="imagenes/index/img1.jpg" />
				<h4>Comentario</h4>
			</article>
			<article>
				<img src="imagenes/index/img1.jpg" />
				<h4>Comentario</h4>
			</article>
			<article>
				<img src="imagenes/index/img1.jpg" />
				<h4>Comentario</h4>
			</article>
			<article>
				<img src="imagenes/index/img1.jpg" />
				<h4>Comentario</h4>
			</article>
			<article>
				<img src="imagenes/index/img1.jpg" />
				<h4>Comentario</h4>
			</article>
			<article>
				<img src="imagenes/index/img1.jpg" />
				<h4>Comentario</h4>
			</article>
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
			<a class="icon-facebook-squared" href="#"></a> <a
				class="icon-twitter-squared" href="#"></a> <a
				class="icon-gmail-squared" href="#"></a>
		</div>
	</footer>

	<script src="js/newJquery-min.js"></script>
	<script src="js/newSlider.js"></script>

</body>

</html>
