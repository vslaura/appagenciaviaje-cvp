<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="../WEB-INF/libreria.tld" prefix="libreria"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agencia de Viajes CVP S.A</title>
</head>
<body>
	<h2>Listado de las categorías</h2>

	<display:table name="${listaCategorias}">
		<display:column title="Código" property="codCate"></display:column>
		<display:column title="Descripción" property="tipoCate"></display:column>
	</display:table>
</body>
</html>