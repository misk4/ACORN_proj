package com.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.service.BoardService;

@WebServlet("/BoardUpdate")
public class BoardUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String savePath = "c:/temp/upload";
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
				
				
		String id = multi.getParameter("id");
		String title = multi.getParameter("title");
		String writer_id = multi.getParameter("writer_id");
		String content = multi.getParameter("content");
		String filepath = multi.getFilesystemName("filepath");
		String filepath2 = multi.getParameter("filepath2");
		if(filepath == null){
			filepath = "null.jpg";
		}
		
		if(filepath.equals("null.jpg") && !filepath2.equals("null.jpg")){
			filepath = filepath2;
		}
		String category = multi.getParameter("category");
		String m_fileFullPath = savePath + "/" + filepath;
		System.out.println(id);
		
		HashMap<String, String> map=
				new HashMap<>();
		map.put("a", id);
		map.put("b", title);
		map.put("c", writer_id);
		map.put("d", content);
		map.put("e", filepath);
		map.put("f", category);
		
		
		BoardService service = new BoardService();
		service.boardUpdate(map);
		response.sendRedirect("BoardList");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
