package com.websystique.springmvc.ws.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.websystique.springmvc.modelo.Afiliacion;

@WebService
@SOAPBinding(style = Style.RPC)
public interface AfiliacionesWSService {

	@WebMethod 
	List<Afiliacion> consultaAfiliaciones(Afiliacion afiliacion) throws Exception;
	
	
}
