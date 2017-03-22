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
import com.entity.StudentattendancelistDTO;
import com.service.AttendanceService;
import com.service.CalendarService;



//출석한 학생보기
@WebServlet("/StudentAttendancelist")
public class StudentAttendancelist extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CalendarService cs = new CalendarService();
		AttendanceService service = new AttendanceService();
		String today = cs.getyymmdd();
		
		List<StudentattendancelistDTO> list = service.studentattendancelist(today);
		
		request.setAttribute("list", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("studentattendancelist.jsp");
		dis.forward(request, response);
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
