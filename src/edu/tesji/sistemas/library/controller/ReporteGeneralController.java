package edu.tesji.sistemas.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tesji.library.utils.SessionAttributes;

@WebServlet(name="/ReporteGeneralController", urlPatterns = {"/reporteGeneral"})
public class ReporteGeneralController extends HttpServlet {

	private static final long serialVersionUID = 3455081689061694228L;
	private static final Logger log = Logger.getLogger(ReporteGeneralController.class);
	

	public ReporteGeneralController() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		log.info("##########Controller Reporte General:" + action);
		
		switch (action) {
		case SessionAttributes.ACTION_INIT:
			log.info("****");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}
