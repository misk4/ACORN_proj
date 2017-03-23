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
	<table width="700" border="3" bordercolor="lightgray" align="center">
        <tr>
            <td>분  류</td>
            <td >
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
		
		</td>
            <td >글번호</td>
            <td ><%=id %>
            <input type="hidden" name="id" value="<%=id %>">
            </td>
            <td>조회수</td>
            <td ><%=readcnt %>
            </td>
        </tr>
            <tr>
            <td>제 목</td>
            <td>
                <input name="title" type="text"  value="<%=title %>">
            </td>       
            <td>작성자</td>
            <td>
                <input name="writer_id" type="text"  value="<%=writer_id %>">
            </td>
            <td>작성일</td>
            <td><%=written_date %></td> 
        </tr>
        <tr>
            <td>
                내 용
            </td>
            <td colspan="5">
                <textarea name="content" cols="72" rows="20"><%=content %></textarea>            
            </td>        
        </tr>
        <tr>
            <td>
                파일첨부
            </td>
            <td colspan="5">
                <input type="file" name="filepath" >
                <span id="filepath">첨부되어있는파일<img src="/images/<%=filepath%>"
				width="100" height="100"></span>
				<input type = "hidden"  name = "filepath2"  value = "<%=filepath %>">
            </td>    
        </tr>
 
        <tr align="center" valign="middle">
            <td colspan="6">
                <input type="reset" value="작성취소" >
                <input type="submit" value="수정" >
                <input type="button" value="목록" 
                onclick= "location.href='BoardList?curpage=${curpage}'">            
            </td>
        </tr>
    </table>    
	<a href="BoardDelete?id=<%=id%>">삭제</a>
</body>
</html>