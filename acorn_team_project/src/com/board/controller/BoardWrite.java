package com.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.entity.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.service.BoardService;

@WebServlet("/BoardWrite")
public class BoardWrite extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String savePath = "c:/temp/upload";
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		String title = multi.getParameter("title");
		String writer_id = multi.getParameter("writer_id");
		String content = multi.getParameter("content");
		String filepath = multi.getFilesystemName("filepath");
		if(filepath == null){
			filepath = "null.jpg";
		}
		String category = multi.getParameter("category");
		String m_fileFullPath = savePath + "/" + filepath;
		
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setWriter_id(writer_id);
		dto.setContent(content);
		dto.setFilepath(filepath);
		dto.setCategory(category);
		
		BoardService service = new BoardService();
		service.boardWrite(dto);
		
			response.sendRedirect("BoardList");
	
			 
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
