package com.article.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.MemberDTO;


@WebServlet("/TodayArticle")
public class TodayArticle extends HttpServlet {

   
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();
		HashMap<String, String> map = new HashMap<>();
		MemberDTO dto = (MemberDTO)session.getAttribute("userid");
		String articlecatergory = dto.getArticlecategory();
		String newscompany = request.getParameter("newscompany");
		
		if(newscompany == null){
			newscompany="중앙일보";
		}
		map.put("newscompany", newscompany);
		map.put("articlecatergory", articlecatergory);
		Articleservice service = new Articleservice();
		//카테고리정보로 rss리스트를 뽑은후 뽑은 rss주소를 텍스트로 변화하는 메서드
		String rss = service.urlreader(map);
		
		session.setAttribute("newscompany", newscompany);
		session.setAttribute("rss", rss);
		RequestDispatcher dis = request.getRequestDispatcher("readarticle.jsp");
		dis.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
