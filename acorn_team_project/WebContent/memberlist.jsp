<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="basicinclude/top.jsp"/>
<jsp:include page="include/memberlist.jsp"/>
<jsp:include page="basicinclude/bottom.jsp"/>

<script>
function aa(){
$(document).ready(function(){

	$.ajax({
	type:"get",
	url:"ajax/authnumberajax.jsp",
	
	dataType:"text",
	success: function(responseData, status,xhr){
		$("#watingnumber").text("현재("+responseData.trim()+"명)");
		
	}
	
	
	})//end ajax
	
	
	


});
}//end function
</script>
