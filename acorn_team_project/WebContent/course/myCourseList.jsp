<%@page import="com.entity.PageDTO"%>
<%@page import="com.entity.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<h1>강의 목록</h1>
<br>
<div class="table-responsive" style="overflow-y: hidden; width: 1000px;">
	
	<c:forEach var="dto" items="${courseList}">
		<table class = "table">
			<tr>
				<th><span style="font-size: 20px;">강의 명</span></th>
				<td colspan = "3"><span style="font-size: 20px;">${dto.name }</span></td>
			</tr>
			
			<tr>
				<th>강의 날짜</th>
				<td>${dto.start_day} ~ ${dto.end_day }</td>
				<th>강의 시간</th>
				<td>${dto.start_time} ~ ${dto.end_time}</td>
			</tr>
			
			<tr>
				<th>강사 </th>
				<td>${dto.teacher_name}&nbsp;&nbsp;[&nbsp;연락처 : ${dto.teacher_phone}, email : ${dto.teacher_email}&nbsp;]</td>
				<th>담당매니저</th>
				<td>${dto.manager_id }&nbsp;&nbsp;[&nbsp;연락처 : ${dto.manager_phone}, email : ${dto.manager_email}&nbsp;]</td>
			</tr>
			
			<tr>
				<th>소요 일수</th>
				<td>${dto.total_days} 일</td>
				<td></td><td></td>
			</tr>
		
		</table>
		
		<br>


	</c:forEach>



</div>

<c:if test="${classification == '관리자' }">
	<a href="CourseRegisterUI">강의 등록</a>
</c:if>









