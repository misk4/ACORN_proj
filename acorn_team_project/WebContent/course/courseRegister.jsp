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
});
</script>
<h1>강의 등록</h1>
<form action="" method="post">
<input type = "hidden" name = "id" value = "${course.id }">
 강의 명 <input type="text" name="name" value = "${course.name }"><br>
선생님 아이디<input type="text" name="teacher_id" value = "${course.teacher_id }"><br>
시작 시간<input type="text" name="start_time" value = "${course.start_time }"><br>
종료 시간<input type="text" name="end_time" value = "${course.end_time }"><br>
시작 날짜 <input type="text" name="start_day" value = "${course.start_day }"><br>
종료 날짜<input type="text" name="end_day" value = "${course.end_day }"><br>
강의 요일<input type="text" name="days" value = "${course.days }"><br>
매니저 아이디<input type="text" name="manager_id" value = "${course.manager_id }"><br>
최대 수강 인원<input type="text" name="max_student" value = "${course.max_student }"><br>
수강 일수 <input type="text" name="total_days" value = "${course.total_days }"><br>

  <input type="submit" id ="submitButton"> 

    <input type="reset" value="초기화">     
</form>