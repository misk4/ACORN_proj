package com.course.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.ScheduleDTO;
import com.exception.CommonException;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.service.CourseService;

/**
 * Servlet implementation class ScheduleRegister
 */
@WebServlet("/ScheduleRegister")
public class ScheduleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String savePath = "c:/temp/upload";
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		String course_id = multi.getParameter("course_id");
		String course_date = multi.getParameter("course_date");
		String content = multi.getParameter("content");
		String filepath = "null";
		if(multi.getFilesystemName("uploadFile")!=null){
		filepath = multi.getFilesystemName("uploadFile");
		}
		System.out.println(course_date+course_id);
		
		ScheduleDTO dto = new ScheduleDTO();
		dto.setCourse_id(Integer.parseInt(course_id));
		dto.setCourse_date(course_date);
		dto.setContent(content);
		dto.setFilepath(filepath);
		
		CourseService service = new CourseService();
		try {
			service.scheduleInsert(dto);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 response.setContentType("text/plain");  
         response.setCharacterEncoding("UTF-8"); 
         response.getWriter().write("success"+course_date+content+filepath);
	}

}
