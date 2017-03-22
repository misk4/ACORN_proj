package com.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.AttendanceDTO;
import com.entity.ManagerDTO;
import com.entity.MemberDTO;
import com.entity.StudentDTO;
import com.entity.TeacherDTO;
import com.service.AttendanceService;
import com.service.CalendarService;
import com.service.MemberService;


@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		HttpSession session = request.getSession();
		MemberDTO dto = new MemberDTO();
		MemberService service = new MemberService();
		AttendanceService atservice = new AttendanceService();
		String course_date=CalendarService.getyymmdd();
		System.out.println("코스데이트:"+course_date);
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		map.put("course_date", course_date);
		dto = service.login(map);
		String target = "";
		if(dto!=null){
		if(dto.getConfirmation()==0){
			response.sendRedirect("watingloginmessage.jsp");
			return;
		};
		};
		List<AttendanceDTO> list =null;
		if(dto instanceof StudentDTO){
			dto.setClassification("학생");
			list = atservice.checkatten(map);
			System.out.println("리스트널?:"+list);
			if(list==null || list.size()==0){
				target = "doattendform.jsp";
			}else{
				target="Attendancechecklist";
				
			}
			
		}else if(dto instanceof ManagerDTO){
			
			dto.setClassification("관리자");
			target = "StudentAttendancelist";
		}else if(dto instanceof TeacherDTO){
			dto.setClassification("선생님");
			target = "notice.jsp";
		}else{
			request.setAttribute("error", 1);
			target="watingloginmessage.jsp";
		}
		session.setAttribute("today", course_date);
		session.setAttribute("userid", dto);
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		
		
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
