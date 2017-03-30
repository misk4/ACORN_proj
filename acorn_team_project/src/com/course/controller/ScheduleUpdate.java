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
 * Servlet implementation class ScheduleUpdate
 */
@WebServlet("/ScheduleUpdate")
public class ScheduleUpdate extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2435209489824468174L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		String savePath = "c:/temp/upload";
		int sizeLimit = 1024*1024*15;
		System.out.println(444);
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		System.out.println(123);
		int id = Integer.parseInt(multi.getParameter("id"));
		String course_date = multi.getParameter("course_date");
		String content = multi.getParameter("content");
		String filepath = multi.getFilesystemName("uploadFile");
		
		System.out.println(id+course_date+content+filepath);
		
		ScheduleDTO dto = new ScheduleDTO();
		dto.setId(id);
		dto.setCourse_date(course_date);
		dto.setContent(content);
		dto.setFilepath(filepath);
		
		CourseService service = new CourseService();
		try {
			service.scheduleUpdate(dto);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 response.setContentType("text/plain");  
         response.setCharacterEncoding("UTF-8"); 
         response.getWriter().write("success"+id+course_date+content+filepath);
	}

}
