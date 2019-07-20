package com.websystique.springmvc.client;

import java.net.URL;
import java.util.Date;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websystique.springmvc.modelo.Afiliacion;
import com.websystique.springmvc.ws.soap.AfiliacionesWSService;

@Controller
@RequestMapping("/")
public class AfiliacionesClienteSOAP {
	
	@RequestMapping("/consulta")
	public static void llamaCliene(String[] args) throws Exception {
		 
	URL url = new URL("http://localhost:7001/Spring4MVCHelloWorldDemo/ws?WSDL");
        QName qname = new QName("http://com.websystique.springmvc.ws.soap/", "AfiliacionesWSServiceImpl");
 
        Service service = Service.create(url, qname);
 
        AfiliacionesWSService hello = service.getPort(AfiliacionesWSService.class);
 
        Afiliacion nuevaAfiliacion = new Afiliacion();
        
        nuevaAfiliacion.setIdAfiliacion(1);
        nuevaAfiliacion.setNumero(1);
        nuevaAfiliacion.setFechaCreacion(new Date());
        nuevaAfiliacion.setNombre("Parametro");
        nuevaAfiliacion.setNumero(2);
        
        System.out.println(hello.consultaAfiliaciones(nuevaAfiliacion));
 
    }
}
