package com.websystique.springmvc.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.websystique.springmvc.criteria.AfiliacionCriteria;
import com.websystique.springmvc.enums.TipoBandejaEnum;
import com.websystique.springmvc.modelo.AfiliacionBO;
import com.websystique.springmvc.service.AfiliacionService;

@Controller
@RequestMapping("/")
public class HelloWorldController {
	
	@Autowired
	AfiliacionService service;
	
	@RequestMapping("/getLogin")
	public ModelAndView getLogin() throws Exception{

		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsp/login");
		
		return mv;
	}
	
	@RequestMapping("/failure")
	public ModelAndView getLogOut() throws Exception{

		ModelAndView mv = new ModelAndView();
		
		consultaREST();
		
		mv.setViewName("jsp/failure");
		
		return mv;
	}
	
	@RequestMapping("/getBandejaGeneral")
	public ModelAndView obtieneBandeja(@RequestParam(value = "idBandejaConsultar",required = false) Integer tipoBandeja) throws Exception{

		System.out.println("MVC - obtieneBandeja: " + tipoBandeja);
		
		ModelAndView mv;		
		mv = getMVCBandeja(tipoBandeja);

		return mv;
	}
	

//	@RequestMapping("/getBandejaInicial")
//	public ModelAndView getBandejaInicial(@RequestParam("user") String usuario,@RequestParam("password") String password) throws Exception{
//
//		System.out.println("MVC - obtieneBandeja" + usuario + password);
//		ModelAndView mv = getMVCBandeja( TipoBandejaEnum.BANDEJA_AFILIACION.getIdBandeja());
//	
//		mv.addObject("user", usuario);
//		mv.addObject("password", usuario);
//
//		return mv;
//	}
	
	@RequestMapping("/getBandejaInicial")
	public ModelAndView getBandejaInicial() throws Exception{

	    User user = (User)SecurityContextHolder.
	    		getContext().getAuthentication().getPrincipal();
	    
	    String nameString = user.getUsername(); //get logged in username
	    
		System.out.println("MVC - obtieneBandeja" + nameString);
		ModelAndView mv = getMVCBandeja( TipoBandejaEnum.BANDEJA_AFILIACION.getIdBandeja());
	
		mv.addObject("user", nameString);

		return mv;
	}
	
	@RequestMapping(value = "/getDatosBandeja") //Puede quedar en un controller general
	public @ResponseBody String obtenerDatosBandeja(@RequestParam(value = "user" ,required = false) String usuario,@RequestParam(value = "tipoBandeja",required = false) Integer tipoBandeja) throws Exception{

		System.out.println("MVC - obtenerDatosBandeja =" + tipoBandeja);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		respuesta.setSuccess(true);
		
		if( tipoBandeja == TipoBandejaEnum.BANDEJA_AFILIACION.getIdBandeja() ){
			respuesta.setModelo( service.getAfiliaciones(null) );
		}else{
			
		}
		
		Gson gson = new Gson();
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	public ModelAndView getMVCBandeja(Integer idTipoBandejaVar) throws Exception{
		
		ModelAndView mv = new ModelAndView();

		TipoBandejaEnum bandeja = null;
		
		bandeja = bandeja.getById(idTipoBandejaVar);
		
		mv.addObject("descripcionBandeja", bandeja.getDescripcion());
		mv.addObject("tipoBandeja", bandeja.getIdBandeja());
		mv.addObject("nombreBandeja", bandeja.getDescripcion());
		
		mv.setViewName(bandeja.getVistaBandeja());
		
		return mv; 
	}	
	
	public static void consultaREST() {

		try {
			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:7001/Spring4MVCHelloWorldDemo/rest/json/rest/get");

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String cadena = response.getEntity(String.class);
			Gson gson = new Gson();
			
			AfiliacionBO output = gson.fromJson(cadena, AfiliacionBO.class);
			System.out.println("Output from Server .... \n");
			System.out.println(output.toString());

		  } catch (Exception e) {

			e.printStackTrace();

		  }
			
		}

}
