package com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.BoardDTO;
import com.entity.PageDTO;
import com.service.BoardService;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList")  
public class BoardList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String curPage = request.getParameter("curPage");
		if(curPage == null){
			curPage = "1";
		}
		BoardService service = new BoardService();
		PageDTO pageDTO = service.boardPage(Integer.parseInt(curPage));
		request.setAttribute("pageDTO", pageDTO);
		
		RequestDispatcher dis=
				request.getRequestDispatcher("boardlist.jsp");
		dis.forward(request, response);
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
