package edu.umkc.ericsson.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.umkc.ericsson.Test;
import edu.umkc.ericsson.bo.ScheduleInfo;
import edu.umkc.ericsson.model.UpdateSchedule_Model;

/**
 * Servlet implementation class UpdateSchedule
 */
@WebServlet("/UpdateSchedule")
public class UpdateSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("InUpdateSchedule::36");
		ArrayList<ScheduleInfo> oldSchedule =new ArrayList<ScheduleInfo>();
		Boolean moreRows=true;
		for(int i=1;moreRows!=false;i++){
		String startTime = "starthour"+i;
		String endTime = "endhour"+i;
		String scheduleId = "scheduleid"+i;
		String scheduleName = "schedulename"+i;
		if(request.getParameter(startTime) != null){
		
		oldSchedule.add(new ScheduleInfo(request.getParameter(scheduleName), new Integer(request.getParameter(startTime)),new Integer(request.getParameter(endTime)),new Integer(request.getParameter(scheduleId))));
		
		System.out.println("Added rows"+i);
		}
		else{
		moreRows=false;
		}
		}
		HttpSession session = request.getSession();
		UpdateSchedule_Model updateSchedule = new UpdateSchedule_Model();
		if (updateSchedule.schedule(oldSchedule))
		{
			session.setAttribute("Message", "Schedule Added Succecfully");
			System.out.println("Added::UpdateSchedule::53");
		}
		else
		{
			session.setAttribute("Message", "Please ensure  schedule is not Overlapping/covered 24 hours ");
			System.out.println("Sorry::UpdateSchedule::58");
		}
		response.sendRedirect("DisplaySchedule");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
