package com.websystique.springmvc.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Endpoint;

import com.websystique.springmvc.ws.soap.AfiliacionesWSServiceImpl;

//import com.websystique.springmvc.wsdl.AfiliacionesWSServiceImpl;

//@WebServlet("/holaServlet")
public class TestServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().print("Hola servlet");
	}
	
	@Override
	public void init() throws ServletException {
		
		System.out.println("Iniciando Web Service SOAP: ");
        Endpoint.publish("http://0.0.0.0:7001/Spring4MVCHelloWorldDemo/ws" ,new AfiliacionesWSServiceImpl());
        //Endpoint.publish("http://0.0.0.0:7002/Spring4MVCHelloWorldDemo/ws" ,new AfiliacionesWSServiceImpl());
        
	}
	
	@PostConstruct
	public void posLoad(){
		System.out.println("Al final se cargó: ");
	}
	
}
