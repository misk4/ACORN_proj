package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.BoardDTO;
import com.service.BoardService;

@WebServlet("/BoardInfo")
public class BoardInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		BoardService service = new BoardService();
			BoardDTO dto = service.boardInfo(Integer.parseInt(id));
			request.setAttribute("boardInfo", dto);
			System.out.println(dto.getFilepath());
			
			RequestDispatcher dis= 
					request.getRequestDispatcher("boardinfo.jsp");
			dis.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
