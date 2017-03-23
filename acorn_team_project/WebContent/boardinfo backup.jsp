<%@page import="java.util.HashMap"%>
<%@page import="com.entity.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
		BoardDTO dto = (BoardDTO)request.getAttribute("boardInfo");
		int id = dto.getId();
		String title = dto.getTitle();
		String writer_id=dto.getWriter_id();
		String content = dto.getContent();
		String filepath = dto.getFilepath();
		String category = dto.getCategory();
		String written_date = dto.getWritten_date();
		int readcnt = dto.getReadcnt();

%>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">

 $(document).ready(function(){
	if($('<%=filepath%>').selector=='null.jpg'){
		$("#filepath").hide();
	}else{
		$("#filepath").show();
 }
 });
</script>
</head>
<body>


	<form action="BoardUpdate" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="<%=id %>"> 글번호:<%=id %>&nbsp;
		작성일:<%=written_date %>&nbsp; 조회수:<%=readcnt %>&nbsp;<br>
		<%
			HashMap<String, String> map = new HashMap<>();
			map.put ("공지사항","공지사항");
			map.put ("정보","정보");
			map.put ("잡담","잡담");
		%>
		<select name="category">
			<% 
			for(String key: map.keySet()){
				if(category.equals(map.get(key))){
		%>
			<option value="<%=map.get(key) %>" selected><%=key %></option>
			<%}else{ %>
			<option value="<%=map.get(key) %>"><%=key %></option>
			<%} %>
			<%} %>
		</select> 제목<input type="text" name="title" value="<%=title %>"><br>
		작성자<input type="text" name="writer_id" value="<%=writer_id %>"><br>
		내용
		<textarea rows="30" cols="30" name="content"><%=content %></textarea>
		<br> 파일첨부<input type="file" name="filepath"><br>
		<span id="filepath">첨부되어있는파일<img src="/images/<%=filepath%>"
				width="100" height="100"></span>
		<input type="submit" value="수정">
	</form>
	<a href="BoardList">목록으로</a>
	<a href="BoardDelete?id=<%=id%>">삭제</a>
</body>
</html>