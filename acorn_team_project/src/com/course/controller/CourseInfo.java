package com.course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.CourseDTO;
import com.entity.MemberDTO;
import com.entity.ScheduleDTO;
import com.exception.CommonException;
import com.service.CourseService;

/**
 * Servlet implementation class CourseInfo
 */
@WebServlet("/CourseInfo")
public class CourseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CourseService service = new CourseService();
	String target = null;
	
	String courseId = request.getParameter("course_id");

	CourseDTO courseDTO = null;
	List<ScheduleDTO> list = null; 
	try {
		courseDTO = service.getCourseById(courseId);
		list = service.getScheduleByCourse(courseId);
		
		request.setAttribute("dto", courseDTO);
		request.setAttribute("scheduleList", list);
		target = "courseInfo.jsp";
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
