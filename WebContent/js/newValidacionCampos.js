/**
 * 
 */

//window.addEventListener("load", function() {
//  miformulario.codigo.addEventListener("keypress", soloNumeros, false);
//});
//
////Solo permite introducir numeros.
//function soloNumeros(e){
//  var key = window.event ? e.which : e.keyCode;
//  if (key < 48 || key > 57) {
//    e.preventDefault();
//  }
//}

$(document).ready(function (){
    limpiarCampos();
    
    $('#btnRegistrar').click(function (){
        validarDatos();
    });
    
    $('#btnCancelar').click(function (){
        history.back();
    });
    
    $('#SelectDepartamento').change(function (){
        $('#text_depart').val("1");
        $.pos
        $.post("cbProvincia.jsp","#frmDepartamento".serialize(),function(data){
            $('#SelectProvincia').html(data);
        });
    });
});