package com.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.AttendanceDTO;
import com.entity.StudentDTO;
import com.service.AttendanceService;


//내 출석 체크리스트

@WebServlet("/Attendancechecklist")
public class Attendancechecklist extends HttpServlet {
	
       
    
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		AttendanceService service = new AttendanceService();
		List<AttendanceDTO> list = null;
		StudentDTO dto = (StudentDTO)session.getAttribute("userid");
		String student_id = dto.getId();		
		list =  service.getattenlist(student_id);
		
		request.setAttribute("list", list);
		RequestDispatcher dis = request.getRequestDispatcher("myattendancecheck.jsp");
		dis.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
