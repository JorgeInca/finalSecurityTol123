var AfiliacionesJS = {
	nuevoAfiliacion : function() {

		$("#btnModalAfiliacion").empty().append("Guardar");
		$("#titleModalAfiliacion").empty().append("Nuevo Afiliacion");
		$("#tipoOperacion").val("guardar");
		$("#idAfiliacion").val("0");	
		
		AfiliacionesJS.limpiaModalAfiliacion();
		
		$('#modalAfiliacion').modal('show');

	},
	editaAfiliacion : function(idAfiliacion) {

		$("#divError").hide(); 
		
		$("#btnModalAfiliacion").empty().append("Actualizar");
		$("#titleModalAfiliacion").empty().append("Actualizar Afiliacion");
		$("#tipoOperacion").val("actualizar");
		$("#idAfiliacion").val(idAfiliacion);
		
		AfiliacionesJS.llenaAfiliacion(idAfiliacion);
		
		$('#modalAfiliacion').modal('show');

	},
	validaEliminarAfiliacion : function(idAfiliacion, descripcion) {

		$("#descripcionEliminarAfiliacion").empty();
		$("#descripcionEliminarAfiliacion").append(descripcion);
		$("#idAfiliacion").val(idAfiliacion);

		$('#modalEliminaAfiliacion').modal('show');

	},
	validaGuardaAfiliacion : function() {    
		
    	$("#divError").empty();
    	$("#divError").hide();  
    	
    	var mensaje = "Está seguro que desea " + $("#tipoOperacion").val() + " este registro?";
    	if( confirm(mensaje) ){
    		
    		if (AfiliacionesJS.camposVaciosFaltantesAfiliacion()){
    			AfiliacionesJS.doNuevoAfiliacion( $("#tipoOperacion").val() );
    		}
    		
    	}else{
    		
    	}	
    },
    doNuevoAfiliacion : function(tipoOperacion) {
    	
		var objAfiliacion = {
				idAfiliacion : $("#idAfiliacion").val(),
				nombre: $("#nombre").val(),
				numero: $("#apellidos").val()				
		};
		
    	$.ajax({
    		method : "POST",
    		url : "doGuardaAfiliacion",
    		data : {
    			esNuevo : $("#tipoOperacion").val() == "guardar" ? "1" : "0",
    			cliente : JSON.stringify(objAfiliacion)
    		},
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success ){
    	        	  alert("Guardado con éxito");
    	        	  BandejaGeneralJS.cargaBandejaGeneral($('#tipoBandeja').val()); 
    	          }
    	          else{
    	        	  alert("Fallo al guardar");
    	          }
      		  },
      		  error : function(e) {
      			  console.log("ERROR: ", e);
      		  }
      		});
    	
		$('#modalAfiliacion').modal('hide');
		
    },
    doEliminaAfiliacion : function() {
    	
    	$.ajax({
    		method : "POST",
    		url : "doEliminaAfiliacion",
    		data : {
    			idAfiliacion : $("#idAfiliacion").val()
    		},
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success ){
    	        	  alert("El registro fue dado de baja");
    	        	  BandejaGeneralJS.cargaBandejaGeneral($('#tipoBandeja').val()); 
    	          }
    	          else{
    	        	  alert("Fallo al eliminar");
    	          }
      		  },
      		  error : function(e) {
      			  console.log("ERROR: ", e);
      		  }
      		});
    	
    },
    llenaAfiliacion: function(idAfiliacion){
    	
  	  $.ajax({
  		method : "POST",
  		url : "getAfiliacionById",
  		data : {
  			idAfiliacion : idAfiliacion
  		},
  		success : function(data) {  			 
  	          var obj=JSON.parse(data);	   
  	          if( obj.success ){	    	        	
  	        	  
  	        	  $("#idAfiliacion").val(obj.modelo.idAfiliacion);
	  	  		  $("#nombre").val(obj.modelo.nombre);
	  			  $("#apellidos").val(obj.modelo.apellidos);
	  			  $("#direccion").val(obj.modelo.direccion);
	  			  $("#telefono").val(obj.modelo.telefono);
	  			  $("#email").val(obj.modelo.email);
	  			  $("#fechaNac").val(obj.modelo.fechaString);	
	  			  $("#fechaNac").change();	  			
	  			  $("#rfc").val(obj.modelo.rfc);
	  			  $("#nombreEmpresa").val(obj.modelo.nombreEmpresa);
  	        
  	          }
  	          else{
  	        	$("#divError").html("Fallo al recuperar");
	  			$("#divError").show();  
  	          }
    		  },
    		  error : function(e) {
        			$("#divError").html("Error: " + e);
    	  			$("#divError").show();     
    		  }
    		});
	
				
  },
  camposVaciosFaltantesAfiliacion: function() {
  	
  	var mensaje = 'Favor de completar los campos: <b>';
  	var empty = true;
  	var coma = "";
  	
		var objValidacion = {
				idAfiliacion : $("#idAfiliacion").val(),
				nombre: $("#nombre").val(),
				apellidos: $("#apellidos").val(),
				direccion: $("#direccion").val(),
				telefono: $("#telefono").val(),
				email: $("#email").val(),
				fechaString: $("#fechaNac").val(),				
				rfc: $("#rfc").val(),
				nombreEmpresa: $("#nombreEmpresa").val()
		};
		
		if( objValidacion.nombre == '' ){
			mensaje = mensaje + "Nombre";		
			empty = false;
		}		
		if( objValidacion.apellidos == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Apellidos";
			empty = false;
		}
		if( objValidacion.direccion == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Dirección";	
			empty = false;
		}
		if( objValidacion.telefono == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Telefono";	
			empty = false;
		}
		if( objValidacion.email == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Email";	
			empty = false;
		}
		if( objValidacion.fechaString == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Fecha de Nacimiento";	
			empty = false;
		}
		if( objValidacion.rfc == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "RFC";	
			empty = false;
		}
		if( objValidacion.nombreEmpresa == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Nombre de Empresa";	
			empty = false;
		}
		
		if( empty==false ){
			mensaje = mensaje + '</b>';
			$("#divError").html(mensaje);
			$("#divError").show();
		}
		
		return empty;
		
  },limpiaModalAfiliacion: function(obra){
    	  $("#divError").hide(); 
    	
		  $("#nombre").val("");
		  $("#apellidos").val("");
		  $("#direccion").val("");
		  $("#telefono").val("");
		  $("#email").val("");
		  $("#fechaNac").val("");
		  $("#edad").val("");
		  $("#rfc").val("");
		  $("#nombreEmpresa").val("");
		  
  }
}