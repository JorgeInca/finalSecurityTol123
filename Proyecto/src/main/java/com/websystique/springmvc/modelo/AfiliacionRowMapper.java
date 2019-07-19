package com.websystique.springmvc.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AfiliacionRowMapper implements RowMapper<Afiliacion> {
	
	public Afiliacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Afiliacion afiliacion = new Afiliacion();
		afiliacion.setIdAfiliacion((rs.getLong("AFILIACION_ID")));
		afiliacion.setNombre((rs.getString("NOMBRE")));
		afiliacion.setNumero((rs.getInt("NUMERO")));
		afiliacion.setEstatus((rs.getInt("ESTATUS")));
		afiliacion.setFechaCreacion((rs.getDate("FECHA_CREACION")));
		
	    return afiliacion;
	}	

}