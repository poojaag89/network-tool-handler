package edu.umkc.ericsson.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.umkc.ericsson.bo.ToolsInfo;
import edu.umkc.ericsson.model.ToolInfo_Model;

/**
 * Servlet implementation class AddToolInfo
 */
@WebServlet("/AddToolInfo")
public class AddToolInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToolInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ToolsInfo newTool=new ToolsInfo(new Integer(request.getParameter("toolId")) , request.getParameter("toolName"), 1);
		ToolInfo_Model addTool=new ToolInfo_Model();
		addTool.add(newTool);
		response.setContentType("text/html");
		response.sendRedirect("ToolsInfo");
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
