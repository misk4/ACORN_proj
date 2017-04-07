<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Insert title here</title>
<style type="text/css">
.Highlighted a {
	background-color: #456baf !important;
	background-image: none !important;
	color: White !important;
	font-weight: bold !important;
	font-size: 12px;
}





</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#modify")
								.on(
										"click",
										function() {
											var tag = "<input type='submit' class='btn btn-warning' value='수정하기!'>"
											$("#att").remove();
											$("input").removeAttr("readonly");
											$(".inner")
													.wrap(
															"<form action='MyInfoModify'/>");
											$("#sub").html(tag);

										})

					});

	$(function() { // 날짜 입력
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1;
		var yyyy = today.getFullYear();
		if (dd < 10) {
			dd = '0' + dd
		}
		if (mm < 10) {
			mm = '0' + mm
		}

		today = yyyy + '/' + mm + '/' + dd; //오늘날짜 ex. 2016/11/12
		
		//데이트피커

		


		//출석날짜 불러오는 에이잭스 

		$.ajax({
			type : "get",
			url : "ajax/datepickerajax.jsp",
			data : {
				v1 : mm
			},
			dataType : "text",
			success : function(responseData, status, xhr) {
				$('#date1').datepicker({showOn: 'both',buttonText: "달력",changeMonth: true,changeYear: true,showButtonPanel:true,
					yearRange: 'c-99:c+99',
					constrainInput: true,maxDate: '+1y',
					beforeShowDay: disableAllTheseDays });
				var attendancedate = responseData.split(",")
				attendancedate[0]=attendancedate[0].trim();
				
				
				function disableAllTheseDays(date) {
					var dd = date.getDate();
					var mm = date.getMonth()+1;
					var yyyy = date.getFullYear();
					if(dd < 10){
						dd = '0'+dd
					}
					if(mm < 10){
						mm = '0'+mm
					}
					dat = yyyy+'-'+mm+'-'+dd;

					
					
					for (i = 0; i < attendancedate.length; i++) {
						if ($.inArray(dat, attendancedate) != -1) {
							return [true,"Highlighted"];
						}
					
				}
					return [true];
				}

			}//end success

		})//ajax

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
		<div id="sub"></div>
	</div>

	<button type="button" class="btn btn-success" id="modify">내정보수정</button>
	<a href="Attendancechecklist" class="btn btn-success" role="button">출석목록보기</a>

	<div class="container" id="att">
		<h2>내 출석률</h2>
		<div class="progress">
			<div class="progress-bar active" role="progressbar"
				aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"
				style="width:${attendancelate}%">${attendancelate }%Complete</div>
		</div>
	</div>

	이번달 출석 보기
	<input type="text" id="date1">


</body>
</html>