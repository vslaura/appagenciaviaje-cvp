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
	<h2>Listado de los Clientes</h2>

	<display:table name="${listaClientes}">
		<display:column title="Código" property="codCli"></display:column>
		<display:column title="DNI" property="dniCli"></display:column>
		<display:column title="Ap. Paterno" property="apePatCli"></display:column>
		<display:column title="Ap. Materno" property="apeMatCli"></display:column>
		<display:column title="Nombre" property="nomCli"></display:column>
		<display:column title="Email" property="emailCli"></display:column>
		<display:column title="Teléfono" property="telefoCli"></display:column>
		<display:column title="Distrito" property="distCli"></display:column>
	</display:table>
</body>
</html>
