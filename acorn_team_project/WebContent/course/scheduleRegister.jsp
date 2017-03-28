<%@page import="com.entity.PageDTO"%>
<%@page import="com.entity.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<h1>강의 일정</h1>
<br>
<div class="table-responsive" style="overflow-y: hidden; width: 1000px;">
		<table class="table">
			<tr>
				<th>날짜</th>
				<th colspan="4">내용</th>
				<th>파일 등록</th>
				<th></th>
			</tr>
			<c:forEach var="dto" items="${scheduleList}" varStatus = "status">
				<tr>
					<td id = "name${status.index}"><input type="text" value="${dto.course_date }"></td>
					<td colspan = "4" id = "content${status.index}"><input type="text" value="${dto.content }"></td>
					<td><img src="/images/${dto.filepath}" width="100" height="100"></td>
					<td><button type = "button" onclick = "update(${status.index})">수정</button></td>
				</tr>



			</c:forEach>

		</table>


</div>







