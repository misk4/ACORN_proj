package com.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.MemberDTO;
import com.service.MemberService;


@WebServlet("/UpdateArticleCategory")
public class UpdateArticleCategory extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String articlecategory = request.getParameter("category");
			MemberDTO dto =(MemberDTO)session.getAttribute("userid");
			String id = dto.getId();
			HashMap<String, String> map = new HashMap<>();
			map.put("articlecategory",articlecategory);
			map.put("id", id);
			MemberService service = new MemberService();
			int k = service.updatearticlecategory(map);
			if(k!=0){
				session.setAttribute("modifyarticle", 1);
				RequestDispatcher dis = request.getRequestDispatcher("TodayArticle");
				dis.forward(request, response);
			}
			
			
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
