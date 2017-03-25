<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
	$(function(){ // 날짜 입력
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1;
		var yyyy = today.getFullYear();
		if(dd < 10){
			dd = '0'+dd
		}
		if(mm < 10){
			mm = '0'+mm
		}
		today = yyyy+'/'+mm+'/'+dd;     //오늘날짜 ex. 2016/11/12
		var todaydate = [today];        //배열에 넣음
		$("#date1").datepicker({ 

			changeMonth: true, 

			changeYear: true, 

			dateFormat: "yymmdd", 						

		        minDate: 0,

		        maxDate: '+1Y+6M',

			showButtonPanel: true,
			beforeShowDay: function(dateStr){
				var dd = dateStr.getDate();
				var mm = dateStr.getMonth()+1;
				var yyyy = dateStr.getFullYear();
				if(dd < 10){
					dd = '0'+dd
				}
				if(mm < 10){
					mm = '0'+mm
				}
				date = yyyy+'/'+mm+'/'+dd;        //jquery 달력의 날짜를 yyyy/mm/dd 형태로 만듬.							
				var Highlight = todaydate[date];    //스타일을 적용할 날짜
				if ($.inArray(date, todaydate) >= 0) {    //jquery달력의 날짜가 오늘날짜와 같다면
					return [true, "Highlighted", Highlight];    //스타일 적용
				}else{
					return [true, '', ''];
				}
			},
		});

	});//end 데이트피커
	
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
	
	이번달 출석 보기<input type="text" id="date1">
	
	
</body>
</html>