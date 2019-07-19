package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.dao.AfiliacionXMLDAO;
import com.websystique.springmvc.modelo.Afiliacion;

public class AfiliacionServiceXMLImpl implements AfiliacionServiceXML{
	
	AfiliacionXMLDAO dao;
	
	public List<Afiliacion>	getAll(){
		return dao.getAll();
	}

	public AfiliacionXMLDAO getDao() {
		return dao;
	}

	public void setDao(AfiliacionXMLDAO dao) {
		this.dao = dao;
	}

	
	
	

}
