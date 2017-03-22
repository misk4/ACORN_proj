package com.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.StudentDTO;
import com.service.AttendanceService;
import com.service.CalendarService;

//출석하지않은사람리스트

@WebServlet("/AbsenceStudentlist")
public class AbsenceStudentlist extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			AttendanceService service = new AttendanceService();
			CalendarService cs = new CalendarService();
			String today = cs.getyymmdd();
			List<StudentDTO> list =  service.getabsencelist(today);
			
			request.setAttribute("list", list);
			RequestDispatcher dis = request.getRequestDispatcher("absence.jsp");
			dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
