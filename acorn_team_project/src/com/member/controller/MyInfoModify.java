package com.member.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.MemberDTO;
import com.entity.StudentDTO;
import com.service.MemberService;


@WebServlet("/MyInfoModify")
public class MyInfoModify extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		HttpSession session = request.getSession();
		HashMap<String, String> map = new HashMap<>();
		Enumeration<String> name = request.getParameterNames();
		while(name.hasMoreElements()){
			String namevalue = name.nextElement();
			String value = request.getParameter(namevalue);
			map.put(namevalue, value);
		}
		StudentDTO dto = (StudentDTO)session.getAttribute("userid");
		
		String id = dto.getId();
		map.put("id", id);
		service.updatemember(map);
		response.sendRedirect("MemberInfo");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
