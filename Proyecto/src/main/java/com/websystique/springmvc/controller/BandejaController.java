
package com.websystique.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.websystique.springmvc.criteria.AfiliacionCriteria;
import com.websystique.springmvc.enums.TipoBandejaEnum;
import com.websystique.springmvc.modelo.Afiliacion;
import com.websystique.springmvc.service.AfiliacionService;

@Controller
public class BandejaController {
	
	@Autowired
	AfiliacionService afiliacionService;
	
	
	@RequestMapping(value = "/getDatosBandejaAfiliacion")
	public @ResponseBody String obtenerDatosBandeja(@RequestParam(value = "user" ,required = false) String usuario,@RequestParam(value = "tipoBandeja",required = false) Integer tipoBandeja) throws Exception{

		System.out.println("MVC - obtenerDatosBandeja =" + tipoBandeja);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		respuesta.setSuccess(true);
		
		if( tipoBandeja == TipoBandejaEnum.BANDEJA_AFILIACION.getIdBandeja() ){
			respuesta.setModelo( afiliacionService.getAfiliaciones(null) );
		}else{
			
		}
	
		Gson gson = new Gson();
        String mensajeJson = gson.toJson(respuesta);
        System.out.println(mensajeJson);
        return mensajeJson;
        
	}
	
	@RequestMapping(value = "/getDatosBandejaCriteria")
	public @ResponseBody String getDatosBandejaCriteria(@RequestParam(value = "user" ,required = false) String usuario,@RequestParam(value = "tipoBandeja",required = false) Integer tipoBandeja,@RequestParam(value = "criteria" ,required = false) String criteria) throws Exception{

		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		respuesta.setSuccess(true);
		Gson gson = new Gson();
		
		
		System.out.println("MVC - getDatosBandejaCriteria =" + tipoBandeja);
		
		if( tipoBandeja == TipoBandejaEnum.BANDEJA_AFILIACION.getIdBandeja() ){
			AfiliacionCriteria afiliacion = gson.fromJson(criteria, AfiliacionCriteria.class);
			respuesta.setModelo( afiliacionService.getAfiliaciones(afiliacion) );
		}else{
			
		}
				
		//Gson gson = new Gson();
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
        
	}
	
	@RequestMapping("/getAfiliacionById")
	public @ResponseBody String getAfiliacionById(@RequestParam("idAfiliacion") Integer idAfiliacion) throws Exception{

		System.out.println("MVC - getAfiliacionById =" + idAfiliacion);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(afiliacionService.getAfiliacionById(idAfiliacion));
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/doGuardaAfiliacion")
	public @ResponseBody String doGuardaAfiliacion(@RequestParam("afiliacion") String AfiliacionJson,@RequestParam("esNuevo") String esNuevo) throws Exception{

		System.out.println("MVC - doGuardaAfiliacion =" + AfiliacionJson);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		Afiliacion Afiliacion = gson.fromJson(AfiliacionJson, Afiliacion.class);
		
		if( Integer.parseInt(esNuevo) == 1){
			afiliacionService.insertaAfiliacion(Afiliacion);			
		}else{
			afiliacionService.actualizaAfiliacion(Afiliacion);			
		}
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	


}
