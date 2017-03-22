package com.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.StudentDTO;
import com.service.AttendanceService;
import com.service.CalendarService;


@WebServlet("/Doattend")
public class Doattend extends HttpServlet {
	
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String logout = request.getParameter("logout");
		StudentDTO dto =(StudentDTO)session.getAttribute("userid");
		AttendanceService service = new AttendanceService();
		HashMap<String, String> map = new HashMap<>();
		String course_date=CalendarService.getyymmdd();
		String tag_time = CalendarService.gethhmmss();
		
		
		String userid = dto.getId();
		map.put("userid", userid);
		map.put("tag_time", tag_time);
		map.put("course_date", course_date);
		int k = service.insertattendance(map);
		if(logout!=null){
			session.invalidate();
			response.sendRedirect("loginform.jsp");
			return;
		}
		
		if(k==1){
			request.setAttribute("map", map);
			RequestDispatcher dis = request.getRequestDispatcher("Attendancechecklist");
			dis.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
