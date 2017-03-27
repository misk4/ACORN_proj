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
import com.exception.CommonException;
import com.service.CourseService;


@WebServlet("/CourseList")
public class CourseList extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseService service = new CourseService();
		String target = null;
		HttpSession session = request.getSession();
		MemberDTO user = (MemberDTO)session.getAttribute("userid");
		
		//git test

		//minsoo
		List<CourseDTO> list = null;
		try {
			list = service.getCourseList();
			if(user.getClassification().equals("학생")){
				list = service.myCourse(list,user.getId());
			}
			request.setAttribute("courseList", list);
			request.setAttribute("classification", user.getClassification());
			target = "courseList.jsp";
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

		doGet(request, response);
	}

}
