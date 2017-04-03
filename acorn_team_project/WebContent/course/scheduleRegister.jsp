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
	
		var formIndex;
		
		$('.divtable').attr('style','display:table');
		$('.divtr').attr('style','display:table-row');
		$(".updateForm").attr("style","display:table-row");
		$(".insertForm").attr("style","display:table-row");
		$(".spantd").attr("style","display:table-cell;word-break:break-all");
		$(".spantd2").attr("style","display:table-cell");
		
		var inputIndex = 1;
		$('.addInputButton').click(function(){
			inputIndex++;
			
			
		});
		
		$('.insertButton').click(function(){
			event.preventDefault();
			console.log(document.getElementsByClassName('updateForm').length);
			 
			var index = inputIndex + document.getElementsByClassName('updateForm').length;
			
			 var form = $('form')[index-1];
			 //var form = $('form[name="'+formName+'"]');
			 console.log(form);
			 var formData = new FormData(form);
			 
			 $.ajax({
				   type:'POSt',
				   url:'/acorn_team_project/ScheduleRegister',
				   data:formData,
				   processData:false,
				   contentType: false,
				   success:function(responseData,status,xhr){
					   alert('반영 성공');
					   location.reload();
				   },
				   error:function(error){
					  console.log(error);   
				   }
			   });
		 
	    });
	
	
	   $('.updateButton').click(function(){
		  event.preventDefault();
		  
		  var index = $(this).attr("id");
		  var form = $('form')[index];
		  console.log(form);
		  var formData = new FormData(form);
		  
		  //formData.append("id",$("input[name==id]").val());
		  //formData.append("course_date",$("input[name==course_date]").val());
		  //formData.append("content",$("input[name==content]").val());
		  //formData.append("uploadFile",$("input[name==uploadFile]")[0].files[0]);
		 
		   
		   //ajax 통신
		   $.ajax({
			   type:'POSt',
			   url:'/acorn_team_project/ScheduleUpdate',
			   data:formData,
			   processData:false,
			   contentType: false,
			   success:function(responseData,status,xhr){
				   alert('수정 성공');
			   },
			   error:function(error){
				  console.log(error);   
			   }
		   });
		   
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

			<form class="updateForm"  method = "post" enctype = "multipart/form-data">
					<input type = "hidden" name = "id" value = "${dto.id }">
					<span class="spantd"><input type="text" value="${dto.course_date }" name="course_date"></span>
					<span class="spantd2"><input type="text" value="${dto.content }" name="content"></span> 
				    <span class="spantd"><input type="file" name="uploadFile"><span class ="spanfile">${dto.filepath }</span><input type="hidden" name="filepath" value = "${dto.filepath }"></span> 
					<span class="spantd"><button class = "updateButton" id ="${status.index}" >수정</button></span>
			</form>
		</c:forEach>
		<input type = "hidden" id = "formIndex" value = 123/>
		<div class="divtr"><button class = "addInputButton" >등록</button><br></div>
		
			<form class="insertForm"  method = "post" enctype = "multipart/form-data" name = "formInput1">
					<input type = "hidden" name = "course_id" value = ${course_id }>
					<span class="spantd"><input type="text" value="" name="course_date"></span>
					<span class="spantd2"><input type="text" value="" name="content"></span> 
				    <span class="spantd"><span class ="spanfile"></span><input type="file" name="uploadFile"><input type="hidden" name="filepath" value = "${dto.filepath }"></span> 
					<span class="spantd"><button class = "insertButton" id ="Input1" >등록</button></span>
			</form>
		
			
			
	</div>








