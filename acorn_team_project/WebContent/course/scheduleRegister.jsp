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
	
		$('.divtable').attr('style','display:table');
		console.log($(".divtable"));
		$('.divtr').attr('style','display:table-row');
		$(".updateForm").attr("style","display:table-row");
		$(".spantd").attr("style","display:table-cell");
		$(".spantd2").attr("style","display:table-cell");
	
	
	   $(".updateForm").submit(function(){
		  event.preventDefault();
		  
		  var $form = $(this);
		  var formData = $form.serializeArray();
		  
		  $.each(formData,function(i,field){
			  console.log(field.value);
		  })
		  
		  var $button = $form.find('button');
		  
		  console.log(formData);
		   
		   
		   //ajax 통신
		   /*$.ajax({
			   type:"get",
			   url:"calc.jsp",
			   data:{
				  v1: $("#v1").val(),
				  v2: $("#v2").val()
			   },
			   success:function(responseData,status,xhr){
				   $("#result").text(responseData);
			   },
			   error:function(error){
				  console.log(error);   
			   }
		   });*/
		   
	   });
});


</script>


<h1>강의 일정</h1>
<br>
	<div class="divtable">
		<div class="divtr">
			<span class="spantd">날짜</span> <span class="spantd2">내용</span> <span
				class="spantd">파일 등록</span> <span class="spantd"></span>
		</div>
		<c:forEach var="dto" items="${scheduleList}" varStatus="status">

			<form class="updateForm" action="ScheduleUpdate" method="post">
					<span class="spantd"><input type="text" value="${dto.course_date }" name="course_date"></span>
					<span class="spantd2"><input type="text" value="${dto.content }" name="content"></span> 
				    <span class="spantd"><img src="/images/${dto.filepath}" width="100"height="100"><input type="file" name="uploadFile"><input type="hidden" name="filepath" value = ""></span> 
					<span class="spantd"><button>수정</button></span>
			</form>

		</c:forEach>

	</div>








