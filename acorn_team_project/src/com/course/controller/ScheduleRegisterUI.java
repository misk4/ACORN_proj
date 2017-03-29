package com.course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.ScheduleDTO;
import com.exception.CommonException;
import com.service.CourseService;

/**
 * Servlet implementation class ScheduleRegisterUI
 */
@WebServlet("/ScheduleRegisterUI")
public class ScheduleRegisterUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseId = request.getParameter("id");
		CourseService service = new CourseService();
		
		List<ScheduleDTO> list = null;
		String target = null;
		try {
			list = service.scheduleList(courseId);
			for (ScheduleDTO scheduleDTO : list) {
				
				System.out.println(scheduleDTO.getContent());
			}
			
			request.setAttribute("scheduleList", list);
			target = "scheduleRegister.jsp";
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target = "error.jsp";
			request.setAttribute("message", e.getMessage());
			request.setAttribute("link", "Home");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
