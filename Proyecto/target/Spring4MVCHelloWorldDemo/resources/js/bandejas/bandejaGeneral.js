var tablaGlobal;

var BandejaGeneralJS = {
	radius : 10,
	cargaBandejaGeneral : function(tipoBandejaVar) {

		tablaGlobal.clear().draw();

		var obj = {};
		obj['user'] = 'jorge';
		obj['tipoBandeja'] = 'loco';

		$.ajax({
			method : "POST",
			url : "getDatosBandeja",
			data : {
				user : '2',
				tipoBandeja : tipoBandejaVar
			},
			success : function(data) {
				var obj = JSON.parse(data);
				if (obj.success) {
					BandejaGeneralJS.llenaDatosBandejaRevolvente(
							tipoBandejaVar, obj.modelo);
				} else {

				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});

	},
	buscaBandejaGeneral : function(tipoBandejaVar, criteriaVar) {

		tablaGlobal.clear().draw();

		var obj = {};
		obj['user'] = 'jorge';
		obj['tipoBandeja'] = 'loco';

		$.ajax({
			method : "POST",
			url : "getDatosBandejaCriteria",
			data : {
				user : '2',
				tipoBandeja : tipoBandejaVar,
				criteria : JSON.stringify(criteriaVar)
			},
			success : function(data) {
				var obj = JSON.parse(data);
				if (obj.success) {
					BandejaGeneralJS.llenaDatosBandejaRevolvente(
							tipoBandejaVar, obj.modelo);
				} else {

				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});

	},
	llenaDatosBandejaRevolvente : function(tipoBandejaVar, modelo) {
		if (modelo.length > 0) {
			modelo.forEach(function(revolvente) {

				var obj = BandejaGeneralJS.llenaObjetoPorTipoBandeja(
						tipoBandejaVar, revolvente);
				console.log(obj);

				tablaGlobal.row.add(obj).draw();
			});
		}
	},
	llenaObjetoPorTipoBandeja : function(tipoBandejaVar, modelo) {
		console.log('tipoBandeja: ' + tipoBandejaVar);
		var obj;

		if (tipoBandejaVar == TipoBandejaEnum.BANDEJA_AFILIACION.idTipoBandeja) {
			obj = {
				id : modelo.idAfiliacion,
				nombre : modelo.nombre,
				numero : modelo.numero,
				fechaAlta : modelo.fechaCreacion,
				estatus : modelo.estatus,
				editar : '<button  id="btnActualizar" class="btn btn-primary btn-sm" onClick="javascript: AfiliacionesJS.editaAfiliacion('
						+ modelo.idAfiliacion
						+ ');"><span style="color: white;"><i class="fas fa-edit"></i></span></button>',
				borrar : '<button  class="btn btn-danger btn-sm" onClick="javascript: AfiliacionesJS.validaEliminarAfiliacion('
						+ modelo.idAfiliacion
						+ ',\''
						+ modelo.descripcion
						+ '\');"><span style="color: white;"><i class="fas fa-trash"></i></span></button>'
			};
		}
		return obj;
	},
	busquedBandejaAfiliacion : function(obra) {

		var fechaInicioFiltro = "";
		var fechaFinFiltro = "";

		if ($("#daterange").val() != "") {
			fechaInicioFiltro = $("#daterange").val().split(' - ')[0];
			fechaFinFiltro = $("#daterange").val().split(' - ')[1];
		}

		var idObraFiltro = $("#idObraFiltro").val();
		var idVehiculoFiltro = $("#idVehiculoFiltro").val();

		$("#daterange").val();

		var criteria = {
			fechaInicio : fechaInicioFiltro,
			fechaFin : fechaFinFiltro,
			idObra : idObraFiltro,
			idVehiculo : idVehiculoFiltro,
		};

		BandejaGeneralJS.buscaBandejaGeneral(TipoBandejaEnum.BANDEJA_REVOLVENTE.idTipoBandeja, criteria);
	}
};
