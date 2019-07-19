/**
 * 
 */
var GeneralJS = {
	    linkBandeja : function(tipoBandejaVar) {
	    	console.log(tipoBandejaVar);
	    	$( "#idBandejaConsultar" ).val(tipoBandejaVar);
	    	$( "#formGetBandeja" ).submit();
	    }		
};


const TipoBandejaEnum = {
		
		BANDEJA_AFILIACION		 		 : { idTipoBandeja : 1, descripcion : "Bandeja afiliacion" 	 	, vistaBandeja : "bandejas/afiliaciones/bandejaAfiliacion/"	},
		
};

$('.number').keypress(function(event) {
	  if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
	    event.preventDefault();
	  }
});