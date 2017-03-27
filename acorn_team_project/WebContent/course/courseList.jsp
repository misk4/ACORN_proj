<%@page import="com.entity.PageDTO"%>
<%@page import="com.entity.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	$(function() {
		$('div.table-responsive').attr('overflow-y', 'hidden');
		//style="overflow-y:hidden; width:500px; height:150px;"
		if('${userid.classification}' == '관리자'){
			$("#th1").html("강의 번호");
		}else if('${userid.classification}' == '학생'){
			$("#th1").html("수강 상태");
		}
	});
</script>

<h1>강의 목록</h1>
<div class="table-responsive" style="overflow-y: hidden; width: 1000px;">
	<c:set var="classification" value="${userid.classification}" scope="session" />
	<table class="table">

		<tr>
			<th id = "th1"></th>
			<th>강의 명</th>
			<th>선생님 이름</th>
			<th>시작 시간</th>
			<th>종료 시간</th>
			<th>시작 날짜</th>
			<th>종료 날짜</th>
			<th>교육 요일</th>
			<th>매니저 아이디</th>
			<th>수강 인원</th>
			<th>수강 일수</th>
		</tr>

		<c:forEach var="dto" items="${courseList}">

			<c:set var="name" value="${dto.name}" scope="request" />

			<c:set var="current" value="${dto.current_student}" scope="page" />
			<c:if test="${dto.current_student  == null}">
				<c:set var="current" value="0" scope="page" />
			</c:if>
			<tr>
				<td>
				<c:if test="${classification == '관리자'}">
				${dto.id }
				</c:if>
				<c:if test="${classification == '학생' && dto.status}">
				수강 중
				</c:if>
				<c:if test="${classification == '학생' && !dto.status}">
				<a href="CourseApply?course_id=${dto.id}&student_id=${sessionScope.userid.id}">강의 신청</a>
				</c:if>
				</td>
				<td>${dto.name }</td>
				<td>${dto.teacher_name }</td>
				<td>${dto.start_time }</td>
				<td>${dto.end_time }</td>
				<td>${dto.start_day }</td>
				<td>${dto.end_day }</td>
				<td>${dto.days }</td>
				<td>${dto.manager_id }</td>
				<td>${current} / ${dto.max_student }</td>
				<td>${dto.total_days }</td>
				<c:if test="${classification == '관리자' }">
					<td><a href="CourseRegisterUI?course_id=${dto.id }">수정</a></td>
					<td><a href="CourseDelete?id=${dto.id }">삭제</a></td>

				</c:if>
			</tr>


		</c:forEach>

	</table>
</div>

<c:if test="${classification == '관리자' }">
	<a href="CourseRegisterUI">강의 등록</a>
</c:if>









