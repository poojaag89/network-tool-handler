package edu.umkc.ericsson.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.umkc.ericsson.bo.ToolsInfo;
import edu.umkc.ericsson.model.ToolInfo_Model;

/**
 * Servlet implementation class RetriveElement_Controller
 */
@WebServlet("/RetriveTools")
public class RetriveElement_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetriveElement_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ToolInfo_Model tools = new ToolInfo_Model();
		ArrayList<ToolsInfo> toolsInfo=tools.getToolInfo();
		HttpSession session =request.getSession();
		session.setAttribute("toolsInfo", toolsInfo);
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
