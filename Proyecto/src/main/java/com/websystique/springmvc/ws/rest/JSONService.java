package com.websystique.springmvc.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.websystique.springmvc.modelo.AfiliacionBO;

@Path("json/rest")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTrackInJSON() {

		AfiliacionBO afiliacion = new AfiliacionBO();
		afiliacion.setIdAfiliacion(1);
		afiliacion.setNombre("banorte");
		
		Gson gson = new Gson();
		
		return gson.toJson(afiliacion);

	}
}