package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.criteria.AfiliacionCriteria;
import com.websystique.springmvc.dao.AfiliacionDAO;
import com.websystique.springmvc.modelo.Afiliacion;

@Service
public class AfiliacionServiceImpl implements AfiliacionService{
	
	@Autowired
	AfiliacionDAO dao;
	
	public List<Afiliacion>	getAfiliaciones(AfiliacionCriteria criteria) throws Exception{
		return dao.getAfiliaciones(criteria);
	}

	public Afiliacion getAfiliacionById(Integer idAfiliacion) throws Exception {
		return dao.getAfiliacionById(idAfiliacion);
	}

	public void insertaAfiliacion(Afiliacion afiliacion) throws Exception {
		dao.insertaAfiliacion(afiliacion);
		
	}

	public void actualizaAfiliacion(Afiliacion afiliacion) throws Exception {
		dao.actualizaAfiliacion(afiliacion);		
	}

	public void eliminaAfiliacion(Integer idAfiliacion) throws Exception {
		dao.eliminaAfiliacion(idAfiliacion);		
	}

}
