
$(document).ready(function(){
listarAlumno();
listarEscuela(0)
limpiar();
});

$("#boton").click(function(){
	var escuela= $("#escuela").val();	
	var nombres = $("#nombres").val();
	var correo= $("#correo").val();
	var celular = $("#celular").val();
	var id = $("#id").val();
	if(id==0){
		$.post( "hc", {escuela :escuela,nombres:nombres,correo:correo,celular:celular, opc:3}).done(function(data){
			limpiar();
			listarEscuela(0)
			listarAlumno();
			});
	}else{
		bootbox.confirm("Desea Modificar?", function(result) {
		if(result){
		 	bootbox.alert("Registro Modificado Correctamente...!", function() {		
			$.post( "hc", {idescuela :escuela, nombres:nombres, correo:correo, celular:celular, ida:id, opc:6}).done(function(data){
				$("#id").val(0);
				limpiar();
				listarEscuela(0)
				listarAlumno();			
			});
		 	});
		}else{
	    	bootbox.alert("El registro no se Modifico...!");
	    	limpiar();
			listarEscuela(0)
			listarAlumno();
	    }});		
	}
});
function listarEscuela(x){
	var i, c =1;
	$("#escuela").empty().append('<option selected="selected" value="test">Seleccionar Escuela</option>')
		$.get("hc", {opc : "1"},
		function(data) {
		var d = JSON.parse(data);
		for (i = 0; i < d.length; i++) {
			if (x == d[i].idescuela) {
				$("#escuela").append(
						"<option selected='selected' value='" + d[i].idescuela + "'>"
								+ d[i].nomescuela + "</option>");
			} else {
				$("#escuela").append(
						"<option value='" + d[i].idescuela + "'>"
								+ d[i].nomescuela + "</option>");
			}
		}
	});	
}

function listarAlumno(){
	var i, c =1;
	$.get("hc",{opc:"2"},function(data){	
		var d = JSON.parse(data);
		$('#tablita tbody').empty();
		for(i=0;i<d.length;i++){
			$("#tablita tbody").append("<tr><td style='color:blue'>"+c+"</td><td>"+d[i].nomescuela+"</td><td>"+d[i].nombres+"</td><td>"+d[i].correo+"</td><td>"+d[i].celular+
			"</td><td><a href='#' style='color:green' onclick='modificar("+d[i].idalumno+")'><i class='far fa-edit'></i></a></td><td><a href='#' style='color:red' onclick='eliminar("+d[i].idalumno+")'><i class='far fa-trash-alt'></i></a></td></tr>")
			c++;
		}
	});
}

function eliminar(id){	
	bootbox.confirm("Desea Eliminar?", function(result) {
    if(result){
    	bootbox.alert("Registro Eliminado Correctamente...!", function() {
    		$.get("hc",{id:id,opc:5},function(data){
     			limpiar();
    			listarEscuela(0);
    			listarAlumno();
		});
    	});
		 
    }else{
    	bootbox.alert("El registro no se Elimino...!")
    }});
}
function modificar(id){	
	$.post("hc",{id:id,opc:4},function(data){
		var x = JSON.parse(data);
		$("#nombres").val(x[0].nombres);
		$("#correo").val(x[0].correo);
		$("#celular").val(x[0].celular);
		$("#id").val(x[0].idalumno);		
		listarEscuela(x[0].idescuela);
	});
}
function limpiar(){
	$("#nombres").val("");
	$("#correo").val("");
	$("#celular").val("");
	$("#nombres").focus();
}
