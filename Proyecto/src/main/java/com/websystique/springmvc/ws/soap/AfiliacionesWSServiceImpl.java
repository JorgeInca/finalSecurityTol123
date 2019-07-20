package com.websystique.springmvc.ws.soap;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.websystique.springmvc.modelo.Afiliacion;
import com.websystique.springmvc.service.AfiliacionService;


@Component
@WebService(endpointInterface = "com.websystique.springmvc.ws.soap.AfiliacionesWSService")
public class AfiliacionesWSServiceImpl extends SpringBeanAutowiringSupport  implements AfiliacionesWSService {

	@Autowired
	AfiliacionService service;
	
	public List<Afiliacion> consultaAfiliaciones(Afiliacion afiliacion) throws Exception{
		
		System.out.println("consultaAfiliaciones WS" + afiliacion.toString() );
		return service.getAfiliaciones(null);
	}

	
}
