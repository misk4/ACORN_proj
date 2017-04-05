<%@page import="com.entity.PageDTO"%>
<%@page import="com.entity.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type = "text/javascript">
$(document).ready(function(){
	
		var formIndex;
		
		$('.divtable').attr('style','display:table');
		
		$('.divtr').attr('style','display:table-row');
		$(".updateForm").attr("style","display:table-row");
		$(".insertForm").attr("style","display:table-row");
		$(".spantd").attr("style","display:table-cell;word-break:break-all");
		$(".spantd2").attr("style","display:table-cell");
		
		$('.divtable').attr('style', 'overflow-y:hidden');
		$('.divtable').attr('style', 'width:1500px');
		
		

});
</script>
<h1>강의 목록</h1>
<br>
<div class="table-responsive" style="overflow-y: hidden; width: 1000px;">
	
		<table class = "table">
			<tr>
				<th><span style="font-size: 20px;">강의 명</span></th>
				<td colspan = "3"><span style="font-size: 20px;"><a href = "ScheduleRegisterUI?id=${dto.id }">${dto.name }</a></span></td>
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
		
		
		<div class="table-responsive" style="overflow-y: hidden; width: 1000px;">
		<table class = "table">
			<tr>
				<th>날짜</th>
				<th>내용</th>
				<th>등록된 자료</th>
			</tr>
		<c:forEach var="scheduleDTO" items="${scheduleList}" varStatus="status">

			<tr>
					
					<td>${scheduleDTO.course_date }</td>
					<td>${scheduleDTO.content }</td>
					<c:if test = "${scheduleDTO.filepath != 'null' }">
				   	<td><a href="/images/${scheduleDTO.filepath }" target="_blank">${scheduleDTO.filepath }</a></td>
					</c:if>
					<c:if test = "${scheduleDTO.filepath == 'null' }">
					<td></td>
					</c:if>
			</tr>
		</c:forEach>
		
		</table>
		</div>
		
		<br>


</div>







