package edu.umkc.ericsson.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.umkc.ericsson.bo.ScheduleInfo;
import edu.umkc.ericsson.bo.ToolsInfo;
import edu.umkc.ericsson.model.ToolInfo_Model;
import edu.umkc.ericsson.model.UpdateSchedule_Model;

/**
 * Servlet implementation class DisplaySchedule_Controller
 */
@WebServlet("/DisplaySchedule")
public class DisplaySchedule_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySchedule_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UpdateSchedule_Model getschedule = new UpdateSchedule_Model();
		List<ScheduleInfo> schedule=getschedule.getSchedule();
		HttpSession session =request.getSession();
		session.setAttribute("schedule", schedule);
		System.out.println("DisplaySchedule::40"+session.getAttribute("schedule"));
		response.sendRedirect("scheduleManagement.jsp");
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
