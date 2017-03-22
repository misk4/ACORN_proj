<%@page import="com.entity.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
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
	<form action="BoardUpdate" method="post">
	<input type="hidden" name="id" value="<%=id %>">
		글번호:<%=id %>&nbsp;
		작성일:<%=written_date %>&nbsp;
		조회수:<%=readcnt %>&nbsp;<br>
		분류<select name ="category" value="<%=category %>">
		<option value="공지사항">공지사항</option>
		<option value="잡담">잡담</option>
		<option value="정보">정보</option>
		</select>
		제목<input type="text" name ="title" value="<%=title %>"><br>
		작성자<input type="text" name="writer_id" value="<%=writer_id %>"><br>
		내용<textarea rows="30" cols="30" name="content"><%=content %></textarea><br>
		파일첨부<input type ="button" value="첨부하기" name="filepath"><img src="/images/<%=filepath%>" width="100" height="100">
		<input type="submit" value="수정">
	</form>
	<a href="BoardList">목록으로</a>
	<a href="BoardDelete?id=<%=id%>">삭제</a>
</body>
</html>