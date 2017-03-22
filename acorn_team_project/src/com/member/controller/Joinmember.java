package com.member.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberService;

/**
 * Servlet implementation class Joinmember
 */
@WebServlet("/Joinmember")
public class Joinmember extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HashMap<String, String> map = new HashMap<>();
		Enumeration<String> names= request.getParameterNames();
		MemberService service = new MemberService();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = request.getParameter(name);
			map.put(name, value);
		}
		System.out.println("들어가기전 어떤이름이찍힐까?:"+map.get("name"));
		int k = service.joinmember(map);
		System.out.println("회원가입 k의값은?"+k);
		response.sendRedirect("loginform.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
