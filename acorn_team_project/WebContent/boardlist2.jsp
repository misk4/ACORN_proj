
<%@page import="com.entity.PageDTO"%>
<%@page import="com.entity.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 
uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
	/* List<BoardDTO> list = 
		(List<BoardDTO>)request.getAttribute("boardList");
 */
 	PageDTO pageDTO =
 	(PageDTO)request.getAttribute("pageDTO");
%>
<h1>게시판	</h1>
	<table border ="1">
		
		<tr>		
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>분류</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<%
		List<BoardDTO> list = pageDTO.getList();
		for(BoardDTO dto : list){
				int id = dto.getId();
				String title = dto.getTitle();
				String writer_id = dto.getWriter_id();
				String category = dto.getCategory();
				String written_date = dto.getWritten_date();
				int readcnt = dto.getReadcnt();
		%>
		<tr>
			<td><%=id %></td>
			<td><a href="BoardInfo?id=<%=id%>"><%=title %></a></td>
			<td><%=writer_id %></td>
			<td><%=category %></td>
			<td><%=written_date %></td>
			<td><%=readcnt %></td>
		</tr>
					
		<%
		}
		%>
		<tr>	
			<td colspan="6">
				<form action="BoardSearch" method="get">
					<select name="searchName">
						<option value ="title">제목</option>
						<option value = "writer_id">작성자</option>
					</select>
						<input type="text" name="searchValue">
						<input type="submit" value="검색">
				</form>
			</td>
		</tr>
<!-- page --> 
  <tr>
   <td colspan="6">
     <%
         int totalCount = pageDTO.getTotalcount();
         int curPage = pageDTO.getCurpage();
    	 int perPage = pageDTO.getPerpage();
    	 int totalPageCount = totalCount/perPage;
    	 if(totalCount%perPage !=0)totalPageCount++;
    	 for(int i = 1; i <= totalPageCount; i++){
        	if(curPage == i){
        		out.print(i+"&nbsp;");
        	}else{
        		out.print("<a href='BoardList?curPage="+i+"'>"+i+"</a>&nbsp;");
        	}//end if

    	 }//end for
     %>
   </td>
  </tr>
 <!-- page -->  
	</table>
	<a href="BoardWriteUi">글쓰기</a>
</body>
</html>