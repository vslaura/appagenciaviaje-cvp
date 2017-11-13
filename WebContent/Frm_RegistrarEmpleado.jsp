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
            <div class="col-md-offset-3 col-md-6">
                <h3>Registro de Empleados</h3>
                <hr /> 

                <form role="form" method="post" action="register">
                <input type="hidden" value="registarEmpleado" name="operacion">
                
                    <div class="form-group">
                      <label for="username">Código</label>
                      <input type="text" value='<libreria:generarCodigoEmpleado/>' class="form-control"  name="txtCodigoEmple" 
                             placeholder="Código" readonly="readonly">
                    </div>
                    <div class="form-group">    
                      <label for="email">Dni</label>
                      <input type="text" class="form-control" name="txtDniEmple"
                             placeholder="Introduce el nro Dni" required="required">
                    </div>
                    <div class="form-group">
                      <label for="password">Nombre</label>
                      <input type="text" class="form-control" name="txtNombreEmple" 
                             placeholder="Entroduce el Nombre" required="required">
                    </div>

                    <div class="form-group">
                      <label >Apellidos</label>
                      <input type="text" class="form-control" name="txtApellidosEmple" 
                             placeholder="Introduce los apellidos" required="required">
                    </div>


                  <div class="form-group">
                          <label class="col-xs-3 control-label">Tipo Empleado</label>
                          <div class="col-xs-9 selectContainer">
                              <select class="form-control" name="txtTipoEmpleado">
                                  <libreria:categoriaEmpleado/>
                              </select>
                          </div>
                      </div>


<br><br>

                   <button type="submit" class="btn btn-info btn-block" onclick=this.form.action="EmpleadoServlet" >Grabar</button>
                 </form>
            </div>           
        </div> 

    </body>
</html>