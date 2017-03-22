package com.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.MemberDTO;
import com.entity.StudentDTO;
import com.service.MemberService;


@WebServlet("/AllMemberlist")
public class AllMemberlist extends HttpServlet {
	
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String mem = request.getParameter("mem");
		MemberService service = new MemberService();
		List<MemberDTO> list=null;
		
		if(mem.equals("학생")){
		list = service.getallstudentlist();
		
		}else if(mem.equals("선생님")){
			list = service.getallteacherlist();
		}else{
			list = service.watingjoinlist();
			
		}
		request.setAttribute("mem", mem);
		request.setAttribute("list", list);
		RequestDispatcher dis = request.getRequestDispatcher("memberlist.jsp");
		dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
