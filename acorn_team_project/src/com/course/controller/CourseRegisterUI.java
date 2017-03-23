package com.course.controller;

import java.io.IOException;

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


@WebServlet("/CourseRegisterUI")
public class CourseRegisterUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		dto = new MemberDTO();
		dto.setClassification("Manager");
		
		String target="";
		
		if(dto != null && dto.getClassification().equals("Manager")){
			
			String id = request.getParameter("course_id");
			if(id != null){
				CourseService service = new CourseService();
				CourseDTO course =null;
				try {
					course = service.getCourseById(id);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CommonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("course", course);
			}
			target="courseRegister.jsp";
		}else{
			target="MemberLogin";
			request.setAttribute("loginFail", "접근 권한이 없습니다.");
		}
		
		RequestDispatcher dis =
        		request.getRequestDispatcher(target);
        dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
