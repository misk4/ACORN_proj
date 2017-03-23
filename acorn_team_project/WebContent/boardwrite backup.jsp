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
	<form action="BoardWrite" method="post" enctype="multipart/form-data">
		
		<select name="category">
			<option value="공지사항">공지사항</option>
			<option value="잡담">잡담</option>
			<option value="정보">정보</option>
		</select>
		제   목<input type="text" name ="title"><br>
		작성자<input type="text" name="writer_id"><br>
		내용<textarea rows="30" cols="30" name="content"></textarea><br>
 		 파일첨부<input type="file" name="filepath"><br/>
  			<input type="submit" value="글작성">
		</form>
	<!-- </form> -->
</body>
</html>