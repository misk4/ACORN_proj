<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	$(document).ready(function() {

		$("#modify").on("click", function() {
			var tag = "<input type='submit' class='btn btn-warning' value='수정하기!'>"
			$("#att").remove();
			$("input").removeAttr("readonly");
			$(".inner").wrap("<form action='MyInfoModify'/>");
			$("#sub").html(tag);

		})


	});
</script>
</head>


<body>
		<div class="inner">
	<table border="3">
		<tr>
			<td>id:${userid.id }</td>
		</tr>
		<tr>
			<td>name:<input type="text" readonly="readonly"
				value="${userid.name }" name="name"></td>
		</tr>
		<tr>
			<td>birthdate:<input type="text" readonly="readonly"
				value="${userid.birthdate }" name="birthdate"></td>
		</tr>
		<tr>
			<td>password:<input type="text" readonly="readonly"
				value="${userid.password }" name="password"></td>
		</tr>
		<tr>
			<td>gender:<input type="text" readonly="readonly"
				value="${userid.gender }" name="gender"></td>
		</tr>
		<tr>
			<td>phone_num:<input type="text" readonly="readonly"
				value="${userid.phone_num }" name="phone_num"></td>
		</tr>
		<tr>
			<td>email:<input type="text" readonly="readonly"
				value="${userid.email }" name="email"></td>
		</tr>
	</table>
	<div id="sub">
	</div>
	</div>	
	
	<button type="button" class="btn btn-success" id="modify">내정보수정</button>
	<a href="Attendancechecklist" class="btn btn-success" role="button">출석목록보기</a>

	<div class="container" id="att">
		<h2>내 출석률</h2>
		<div class="progress">
			<div class="progress-bar active" role="progressbar"
				aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"
				style="width:${attendancelate}%">${attendancelate }% Complete
			</div>
		</div>
	</div>
</body>
</html>