package com.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.CommentDTO;
import com.entity.MemberDTO;
import com.service.CommentService;

/**
 * Servlet implementation class CommentWrite
 */
@WebServlet("/CommentWrite")
public class CommentWrite extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
      request.setCharacterEncoding("UTF-8");
      String target=""; 
      String content=request.getParameter("content");
      
      HttpSession session = request.getSession();
      MemberDTO mdto = (MemberDTO)session.getAttribute("userid");
      CommentDTO commentdto= new CommentDTO();
      if(mdto != null){
         int id=Integer.parseInt(request.getParameter("id"));
         CommentService service= new CommentService();
         commentdto.setContent(content);
         commentdto.setBoard_id(id);
         commentdto.setWriter_id(mdto.getId());
         
         System.out.println(commentdto);
         
         
         service.replyWrite(commentdto);
         target="BoardInfo?id="+ id;
         
      }else{
         target="Home"; // 로그인 확인
         session.setAttribute("loginFail", "로그인 후 시도하세요");
      }
      response.sendRedirect(target);
      
           
   }
   

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}