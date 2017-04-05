<%@page import="com.entity.PageDTO"%>
<%@page import="com.entity.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
$(document).ready(function(){
		$('div.table-responsive').attr('overflow-y', 'hidden');
		//style="overflow-y:hidden; width:500px; height:150px;"
		if('${userid.classification}' == '관리자'){
			$("#th1").html("강의 번호");
		}else if('${userid.classification}' == '학생'){
			$("#th1").html("수강 상태");
		}
		
		var count =1;
		
		$('.selectAll').click(function(){
			if(count%2==1){
				$('input:checkbox[name="deleteCheck"]').attr("checked",true);
				count++;
			}else{
				$('input:checkbox[name="deleteCheck"]').attr("checked",false);
				count++;
			}
			
		});
		
		$('.deleteButton').click(function(){
			var courseList = new Array;
			 
			$('input:checkbox[name="deleteCheck"]').each(function() {
				var value = $(this).val();
				if(this.checked){
					courseList.push(value);
				}
				 

			 });
			 
			 console.log(courseList[0]);
			 
			 $.ajax({
			        url:"CourseDelete",
			        type:'POST',
			        data: {courseList:courseList},
			        success:function(data){
			            alert("삭제 완료!");
			           	location.reload();
			        },
			        error:function(jqXHR, textStatus, errorThrown){
			            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
			            console.log(jqXHR); 
			        }
			    });
			 
			
		});
		
		$('.searchCourse').click(function(){
			var key = $('#searchKey').val();
			
			function reset(){
				$('.TD').each(function() {
				$(this).parent('tr').css('color', 'black');
				$(this).parent('tr').css('background-color', 'white');
				
				});
				
				return Promise.resolve();
			}
			
			function highlight(){
				$('.TD').each(function() {
				if(this.innerText.includes(key)){
					$(this).parent('tr').css('color', 'red');
					$(this).parent('tr').css('background-color', 'yellow');
				}
				});
				
				return Promise.resolve();
			}	
				
				reset().then(highlight);
				
			
			
		});



});
</script>

<h1>강의 목록</h1>
<div class="table-responsive" style="overflow-y: hidden; width: 1200px;">
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
			<c:if test="${classification == '관리자' }">
			<th><button class = "selectAll">전체선택</button></th><th><button class = "deleteButton">삭제</button></th>
			</c:if>
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
				<td class = "TD"><a href = "CourseInfo?course_id=${dto.id}">${dto.name }</a></td>
				<td class = "TD">${dto.teacher_name }</td>
				<td class ="TD">${dto.start_time }</td>
				<td class ="TD">${dto.end_time }</td>
				<td class ="TD">${dto.start_day }</td>
				<td class ="TD">${dto.end_day }</td>
				<td class ="TD">${dto.days }</td>
				<td class ="TD">${dto.manager_id }</td>
				<td>${current} / ${dto.max_student }</td>
				<td class ="TD">${dto.total_days }</td>
				<c:if test="${classification == '관리자' }">
					<td><a href="CourseRegisterUI?course_id=${dto.id }">수정</a></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type ="checkbox" name ="deleteCheck" value ="${dto.id }"></td>

				</c:if>
			</tr>


		</c:forEach>

	</table>
</div>

<c:if test="${classification == '관리자' }">
	<a href="CourseRegisterUI">강의 등록</a>
</c:if>

<input type = "text" id = "searchKey"><button class ="searchCourse">검색</button>









