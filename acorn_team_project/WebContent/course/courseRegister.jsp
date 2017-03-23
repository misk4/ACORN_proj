<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 
uri="http://java.sun.com/jsp/jstl/functions" %>    
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type = "text/javascript">
$(document).ready(function(){
	var course = '${course}';
	console.log(course);
	if(course == ''){
		$("form").attr("action","CourseRegister");
		$("#submitButton").val("등록");
	}else{
		$("form").attr("action","CourseUpdate");
		$("#submitButton").val("수정");
	}
	
	$("th").attr("width",120);
	$("input").attr("width",1000);
});
</script>
<h1>강의 등록</h1>
<div class = "table-responsive">
<form action="" method="post" class = "table-responsive">
<input type = "hidden" name = "id" value = "${course.id }">

<table class = "table">
<tr>
	<th>강의 명 </th>
	<td><input type="text" name="name" value = "${course.name }"></td>
</tr>

<tr>
	<th>선생님 아이디</th>
	<td><input type="text" name="name" value = "${course.teacher_id }"></td>
</tr>

<tr>
	<th>시작 시간</th>
	<td><input type="text" name="start_time" value = "${course.start_time }"></td>
</tr>

<tr>
	<th>종료 시간</th>
	<td><input type="text" name="end_time" value = "${course.end_time }"></td>
</tr>

<tr>
	<th>시작 날짜</th>
	<td><input type="text" name="start_day" value = "${course.start_day }"></td>
</tr>

<tr>
	<th>종료 날짜</th>
	<td><input type="text" name="end_day" value = "${course.end_day }"></td>
</tr>

<tr>
	<th>강의 요일</th>
	<td><input type="text" name="days" value = "${course.days }"></td>
</tr>

<tr>
	<th>매니저 아이디</th>
	<td><input type="text" name="manager_id" value = "${course.manager_id }"></td>
</tr>



<tr>
	<th>최대 수강 인원</th>
	<td><input type="text" name="max_student" value = "${course.max_student }"></td>
</tr>

<tr>
	<th>수강 일수 </th>
	<td><input type="text" name="total_days" value = "${course.total_days }"></td>
</tr>



</table>

&nbsp;&nbsp;&nbsp;<input type="submit" id ="submitButton"> 
&nbsp;&nbsp;<input type="reset" value="초기화">  

</form>
</div>

   
