package com.websystique.springmvc.dao;
import java.util.List;

import com.websystique.springmvc.criteria.AfiliacionCriteria;
import com.websystique.springmvc.modelo.Afiliacion;

public interface AfiliacionDAO {

	public List<Afiliacion> getAfiliaciones(AfiliacionCriteria criteria) throws Exception;
	
	public Afiliacion getAfiliacionById(Integer idAfiliacion) throws Exception;
	
	public void insertaAfiliacion(Afiliacion afiliacion) throws Exception;

	public void actualizaAfiliacion(Afiliacion afiliacion) throws Exception;
	
	public void eliminaAfiliacion(Integer idAfiliacion) throws Exception;
}
