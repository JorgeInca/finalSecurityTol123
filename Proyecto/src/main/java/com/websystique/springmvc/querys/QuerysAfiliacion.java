package com.websystique.springmvc.querys;

import org.springframework.stereotype.Repository;

@Repository 
public class QuerysAfiliacion{

	public static final String GET_AFILIACIONES = "SELECT AF.* FROM AFILIACION AF WHERE 1 = 1";
	
	public static final String GET_AFILIACIONES_ESTATUS = " AND AF.ESTATUS = :idEstatus ";
	
	public static final String ID_AFILIACION = " and AF.AFILIACION_ID  = :idAfiliacion ";
	
	public static final String INSERT_AFILIACION = " INSERT INTO AFILIACION (AFILIACION_ID,NOMBRE,NUMERO) " 
			+" VALUES (AFILIACION_SEQ.NEXTVAL,:nombre,:numero) "; 
	
	public static final String ACTUALIZA_AFILIACION = " UPDATE AFILIACION AF SET "
			+ " AF.NOMBRE = :nombre, "
			+ " AF.DIRECCION = :direccion, "
			+ " AF.CLIENTE_ID = :idCliente "			
			+ "	WHERE 1 = 1 "; 
	
	public static final String BAJA_AFILIACION = "UPDATE AFILIACION AF SET "
			+ " AF.ESTATUS = :idEstatus "
			+ "	WHERE 1 = 1 "; 
	
	public static final String GET_AFILIACIONES_AND_FECHA = " and FECHA_ALTA between :fechaInicio and :fechaFin ";

}