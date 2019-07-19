package com.websystique.springmvc.dao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.criteria.AfiliacionCriteria;
import com.websystique.springmvc.enums.EstatusEnum;
import com.websystique.springmvc.modelo.Afiliacion;
import com.websystique.springmvc.modelo.AfiliacionRowMapper;
import com.websystique.springmvc.querys.QuerysAfiliacion;
@Repository
public class AfiliacionDAOImpl extends BasicDAO implements AfiliacionDAO{
	
	String sql = " SELECT * FROM AFILIACION";
	
	@Autowired
	private DataSource dataSource;
	 

	public List<Afiliacion> getAfiliaciones(AfiliacionCriteria criteria) throws Exception{
		System.out.println("DAO - getAfiliacions");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		String sql = "";
		
		parameters.put("idEstatus", EstatusEnum.ACTIVO.getIdEstatus());
		
		if(criteria != null && !criteria.isEmpty() ){ //Criteria
			sql = QuerysAfiliacion.GET_AFILIACIONES;
			sql = sql + QuerysAfiliacion.GET_AFILIACIONES_ESTATUS;
			
			if( !criteria.getFechaInicio().equals("") && !criteria.getFechaFin().equals("")){
				
				sql = sql + QuerysAfiliacion.GET_AFILIACIONES_AND_FECHA;
				
				parameters.put("fechaInicio", criteria.getFechaInicio());
				parameters.put("fechaFin", criteria.getFechaFin());
			}
		}else{
			sql = QuerysAfiliacion.GET_AFILIACIONES;
			sql = sql + QuerysAfiliacion.GET_AFILIACIONES_ESTATUS;
			
		}
			
			
		System.out.println( "PLSQL " + ejecutaSumaProcedimiento());
			
		return getNamedJdbcTemplate().query(sql,parameters,new AfiliacionRowMapper());
	}
	
	
	public Afiliacion getAfiliacionById(Integer idAfiliacion) throws Exception{
		System.out.println("DAO - getAfiliacionById");
		
		String sql = QuerysAfiliacion.GET_AFILIACIONES;
		sql = sql + QuerysAfiliacion.ID_AFILIACION;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idAfiliacion", idAfiliacion);
			
		List<Afiliacion> listaAfiliacions = new ArrayList<Afiliacion>();
				
		listaAfiliacions = getNamedJdbcTemplate().query(sql,parameters,new AfiliacionRowMapper());
		
		if(listaAfiliacions.size()>0){
			return listaAfiliacions.get(0);
		}
		return new Afiliacion();
	}
	
	
	public void insertaAfiliacion(Afiliacion afiliacion) throws Exception{
		System.out.println("DAO - insertaAfiliacion");
		
		String sql = QuerysAfiliacion.INSERT_AFILIACION;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nombre", afiliacion.getNombre());
		parameters.put("numero", afiliacion.getNumero());

		getNamedJdbcTemplate().update(sql,parameters);

	}

	
	public void actualizaAfiliacion(Afiliacion afiliacion) throws Exception{
		System.out.println("DAO - actualizaAfiliacion");
		
		String sql = QuerysAfiliacion.ACTUALIZA_AFILIACION;
		sql = sql + QuerysAfiliacion.ID_AFILIACION;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nombre", afiliacion.getNombre());
		parameters.put("numero", afiliacion.getNumero());
		parameters.put("idAfiliacion", afiliacion.getIdAfiliacion());

		//parameters.put("idAfiliacion", revolvente.getIdAfiliacion());

		
		getNamedJdbcTemplate().update(sql,parameters);
		
	}
	
	
	public void eliminaAfiliacion(Integer idAfiliacion) throws Exception{
		System.out.println("DAO - bajaAfiliacion");
		
		String sql = QuerysAfiliacion.BAJA_AFILIACION;
		sql = sql + QuerysAfiliacion.ID_AFILIACION;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idAfiliacion", idAfiliacion);
		parameters.put("idEstatus", EstatusEnum.CANCELADO.getIdEstatus());

		getNamedJdbcTemplate().update(sql,parameters);
		
	}
	
	public BigDecimal ejecutaSumaProcedimiento(){
		
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("SUMA");
		SqlParameterSource in 
		= new MapSqlParameterSource().addValue("NUMERO_UNO", 4).addValue("NUMERO_DOS", 6);

		Map<String, Object> out = jdbcCall.execute(in);
		
		return (BigDecimal) out.get("RESULTADO"); 
	}
	
	
}
