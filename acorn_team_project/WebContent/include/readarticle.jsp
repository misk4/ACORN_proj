//


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 
uri="http://java.sun.com/jsp/jstl/functions" %> 
<style>
.article{
font-size:20px;
}


</style>   
  
<script type="text/javascript">
	 
 $.ajax({
	   type:"GET",
	   url:"ajax/readarticleajax.jsp",
	   dataType:"text",
	   success:function(responseData,status,xhr){
		  var x = $.parseXML(responseData.trim());
		   
		   var mesg = "";
		$(x).find("item").each(function(idx,obj){
			   var link =  $(this).find("link").text();
			   var title = $(this).find("title").text();
			   var aa ="<form method='POST' action='GoHtml' id='"+idx+"'>";
			   var aa2 = "<a href=# onclick='formSubmit("+idx+"); return false;'>"
			   var input = "<input type='hidden' name='link' value='"+link+"'>"
			   var aa3 = "</a></form><br>"
			   mesg +=aa+aa2+title+input+aa3;
			   
									

			   
		   });

		   $("#result").append(mesg+"<br>");
	   },
	   error:function(error){
		  console.log(error);   
	   }
});
		 
 
 function formSubmit(aa){
	 
	 document.getElementById(aa).submit();
	 
 }
	

	




</script>
<h1>${newscompany }</h1><br>
<div id="result" class="article"></div>



