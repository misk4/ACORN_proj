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
import com.entity.CommentDTO;
import com.service.BoardService;
import com.service.CommentService;

@WebServlet("/BoardInfo")
public class BoardInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
	      BoardService service = new BoardService();
	      CommentService commentService = new CommentService();
	      
	         BoardDTO dto = service.boardInfo(Integer.parseInt(id));
	         List<CommentDTO> commentList = commentService.commentList(Integer.parseInt(id));
	         request.setAttribute("boardInfo", dto);
	         request.setAttribute("commentList", commentList);
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
