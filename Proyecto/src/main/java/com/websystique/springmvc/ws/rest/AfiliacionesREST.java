package com.websystique.springmvc.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.modelo.Afiliacion;
import com.websystique.springmvc.service.AfiliacionService;

@RestController
public class AfiliacionesREST {
	
	@Autowired
	AfiliacionService servicio;
	
	@RequestMapping(value="/afRest", method=RequestMethod.GET)
	public List<Afiliacion> getAfiliaciones() throws Exception{
        return servicio.getAfiliaciones(null);
    }
	
	
	
}
