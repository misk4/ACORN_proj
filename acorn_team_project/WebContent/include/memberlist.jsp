<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script>
$(document).ready(function(){

$("button").on("click",function(){
	
	$.ajax({
		type: "get",
		url:"ajax/updateconfirmationajax.jsp",
		data: {
			v1:$("#v1").val()
		},
		dataType:"text",
		success: function(responseData, status, xhr){
			
			$("#button").remove;
			$("#result").text("승인완료");
			
			
		}
	
	})//ajax
	

	
})//on click


})//end document
</script>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생일</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>승인</th>
			</tr>
		</thead>
		<c:forEach var="list" items="${list}">
			<tbody>
				<tr>
					<td>${list.id }</td>
					<td>${list.name }</td>
					<td>${list.birthdate }</td>
					<td>${list.gender }</td>
					<td>${list.phone_num }</td>
					<td>${list.email }</td>
					<c:if test="${mem == '가입'}">
					<input type="hidden" name="v1" id="v1" value="${list.id }">
					<td id="result"><button type="button" class="btn btn-danger" id="button">승인</button></td>
					</c:if>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>


