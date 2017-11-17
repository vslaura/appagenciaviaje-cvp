<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="../WEB-INF/libreria.tld" prefix="libreria"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
       
<link rel="stylesheet" href="/vendor/bootstrap-combobox/css/bootstrap-combobox.css">

        <title>Agencia de Viajes CVP S.A</title>
    </head>
    <body>
        <div class="container">
        
            <div class="col-md-offset-2 col-md-3">
                <h4>Registro de departamentos</h4>
                <hr /> 
                
                <form role="form" method="post" action="register">
                	<input type="hidden" value="registrarDepartamento" name="operacion">
                    <div class="form-group">
                      
                      <input type="text" value='<libreria:generarCodigoDepartamento/>' class="form-control" name="txtCodigoDepartamento" 
                             placeholder="Código"  readonly="readonly" >
                    </div>
                    <div class="form-group">    
                      <input type="text" class="form-control" name="txtDescripcionDepartamento"
                             placeholder="Introduce el departamento" required="required">
                   
                 </div>
<br><br>

                   <button type="submit" class="btn btn-info btn-block" onclick=this.form.action="DepartamentoServlet">Registrar</button>
                 </form>
                 <div id="mensaje">${param.msj}</div>
                 
            </div>           
        </div> 

    </body>
</html>