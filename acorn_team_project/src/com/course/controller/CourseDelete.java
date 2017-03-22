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


@WebServlet("/CourseDelete")
public class CourseDelete extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseService service = new CourseService();
		String target = null;
		int courseId = Integer.parseInt(request.getParameter("id"));
		try {
			service.deleteCourse(courseId);
			response.sendRedirect("CourseList");
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target = "error.jsp";
			request.setAttribute("message", e.getMessage());
			request.setAttribute("link", "Home");
			RequestDispatcher dis = request.getRequestDispatcher(target);
			dis.forward(request, response);
		}
		
		
	}

}
