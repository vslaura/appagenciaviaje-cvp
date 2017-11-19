<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="../WEB-INF/libreria.tld" prefix="libreria"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Listado de los Empleados</h2>

	<display:table name="${listaEmpleados}">
		<display:column title="Código" property="codEmp"></display:column>
		<display:column title="DNI" property="dniEmp"></display:column>
		<display:column title="Nombre " property="nomEmp"></display:column>
		<display:column title="Apellidos" property="apellEmp"></display:column>
		<display:column title="Tipo Empleado" property="categoria"></display:column>
		
		
	</display:table>
</body>
</html>