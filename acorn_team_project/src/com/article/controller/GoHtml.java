package com.article.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GoHtml")
public class GoHtml extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String link = request.getParameter("link");
		System.out.println("링크"+link);
		Articleservice service = new Articleservice();
		HashMap<String, String> map = new HashMap<>();
		map.put("link", link);
		String myhtml = service.urlreader(map);
		request.setAttribute("myhtml", myhtml);
		RequestDispatcher dis = request.getRequestDispatcher("viewarticle.jsp");
		dis.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
