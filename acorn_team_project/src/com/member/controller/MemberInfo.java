package com.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.AttendanceDTO;
import com.entity.MemberDTO;
import com.entity.StudentDTO;
import com.service.AttendanceService;
import com.service.CalendarService;


@WebServlet("/MemberInfo")
public class MemberInfo extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("userid");
		AttendanceService service = new AttendanceService();
		HashMap<String, String> map = new HashMap<>();
		CalendarService service2 = new CalendarService();
		String mm=service2.getyymmdd().substring(3,5);
		String student_id = dto.getId();
		map.put("mm", mm);
		map.put("student_id", student_id);
		int attendanceday = service.getattendanceday(map);
		int attendancelate = (attendanceday*100)/18 ;
		request.setAttribute("attendancelate", attendancelate);
		RequestDispatcher dis = request.getRequestDispatcher("myinfo.jsp");
		dis.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
