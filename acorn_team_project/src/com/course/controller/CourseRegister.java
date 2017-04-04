package com.course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CourseDTO;
import com.exception.CommonException;
import com.service.CourseService;


@WebServlet("/CourseRegister")
public class CourseRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		CourseDTO course = new CourseDTO();
		course.setName(request.getParameter("name").toString());
		course.setTeacher_id(request.getParameter("teacher_id").toString());
		course.setStart_time(request.getParameter("start_time").toString());
		course.setEnd_time(request.getParameter("end_time").toString());
		course.setStart_day(request.getParameter("start_day").toString());
		course.setEnd_day(request.getParameter("end_day").toString());
		course.setDays(request.getParameter("days").toString());
		course.setManager_id(request.getParameter("manager_id").toString());
		course.setMax_student(Integer.parseInt(request.getParameter("max_student").toString()));
		course.setTotal_days(Integer.parseInt(request.getParameter("total_days").toString()));
		
		System.out.println(course);
		CourseService service = new CourseService();
		String target = null;
		
		try {
			service.registerCourse(course);
			//target = "CourseList";
			response.sendRedirect("CourseList");
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target = "error.jsp";
			request.setAttribute("message", e.getMessage());
			request.setAttribute("link", "CourseRegisterUI");
			RequestDispatcher dis = request.getRequestDispatcher(target);
			dis.forward(request, response);
			
		}
		
		
	}

}
