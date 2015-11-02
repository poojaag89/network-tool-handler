package edu.umkc.ericsson.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

import edu.umkc.ericsson.bo.ElementInfo;
import edu.umkc.ericsson.model.AddElement_model;
import edu.umkc.ericsson.model.ElementInfo_Model;

/**
 * Servlet implementation class Element_Controller
 */
@WebServlet("/Element_Controller")
public class Element_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Element_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       HttpSession session=request.getSession();
		
		String toolname=(String)request.getParameter("toolNameSelect");
		System.out.println(toolname);
		session.setAttribute("selectedToolName",toolname);
		ElementInfo_Model elements=new ElementInfo_Model();
		
		session.setAttribute("elementInfo", elements.getElements(toolname));
		if(request.getParameter("elementAdd")!=null){
			ElementInfo elementOperations= new ElementInfo(new Integer(request.getParameter("id")), request.getParameter("name"), request.getParameter("name"), toolname, request.getParameter("time"), 1,"", "UMKC");
			AddElement_model am= new AddElement_model();
			am.add(elementOperations);
			}
		response.sendRedirect("elementManagement.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
