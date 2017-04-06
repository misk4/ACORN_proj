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
	   
	   
	   $('.deleteButton').click(function(){
			var scheduleList = new Array;
			 
			$('input:checkbox[name="deleteCheck"]').each(function() {
				var value = $(this).val();
				if(this.checked){
					scheduleList.push(value);
				}
				 

			 });
			 
			 $.ajax({
			        url:"ScheduleDelete",
			        type:'POST',
			        data: {scheduleList:scheduleList},
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
});


</script>


<h1>강의 일정</h1>
<br>
	<div class="table-responsive" style="overflow-y: hidden; width: 1200px;">
		<div class="divtr">
			<span class="spantd">날짜</span> <span class="spantd2">내용</span> <span
				class="spantd">파일 등록</span> <span class="spantd">등록된 파일</span><span class="spantd"></span><span class="spantd"><button class = "deleteButton" id ="${status.index}" >삭제</button><button class = "selectAll">전체선택</button></span>
		</div>
		<c:forEach var="dto" items="${scheduleList}" varStatus="status">

			<form class="updateForm"  method = "post" enctype = "multipart/form-data">
					<input type = "hidden" name = "id" value = "${dto.id }">
					<span class="spantd"><input type="text" value="${dto.course_date }" name="course_date"></span>
					<span class="spantd2"><input type="text" value="${dto.content }" name="content"></span> 
				    <span class="spantd" ><input type="file" name="uploadFile" style="width:200px"><input type="hidden" name="filepath" value = "${dto.filepath }"></span> 
					<span class="spantd" ><span class ="spanfile">${dto.filepath }</span></span>
					<span class="spantd"><button class = "updateButton" id ="${status.index}" >수정</button></span><span class="spantd">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "checkbox" name = "deleteCheck" value ="${dto.id }"></span>
			</form>
		</c:forEach>
		<input type = "hidden" id = "formIndex" value = 123/>
		
		<hr>
			<form class="insertForm"  method = "post" enctype = "multipart/form-data" name = "formInput1">
					<input type = "hidden" name = "course_id" value = ${course_id }>
					<span class="spantd"><input type="text" value="" name="course_date"></span>
					<span class="spantd2"><input type="text" value="" name="content"></span> 
				    <span class="spantd" ><span class ="spanfile"></span><input type="file" name="uploadFile" style="width:200px"><input type="hidden" name="filepath" value = "${dto.filepath }"></span> 
					<span class="spantd"><button class = "insertButton" id ="Input1" >등록</button></span>
			</form>
		
		</table>
			
	</div>








