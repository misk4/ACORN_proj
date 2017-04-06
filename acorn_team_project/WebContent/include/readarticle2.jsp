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
line-height:200%
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
			   var aa2 = "<a href=# onclick='formSubmit("+idx+"); return false;'>"
			   var aa3 = "</a><br>"
				var input = "<input type='hidden' id='"+idx+"' name='link' value='"+link+"'>"
			   mesg +=aa2+title+aa3+input+"<br>";
			   
									

			   
		   });

		   $("#result").append(mesg+"<br>");
	   },
	   error:function(error){
		  console.log(error);   
	   }
});
		 
 
 function formSubmit(idx){
	 
	 var x = document.getElementById(idx);
	 var xx = x.value;
	 $.ajax({
		type:"get",
		url:"ajax/readhtmlajax.jsp",
		data:{
			v1:xx
		},
		dataType : "text",
		success: function(responsData,status,xhr){
			
			var xx = $.parseHTML(responsData.trim());
	 		var myhtmltitle = $(xx).find(".subject").text();
	 		var info = $(xx).find(".byline").text();
	 		var myhtmlcontent = $(xx).find("#article_body").text();
	 		
	 		var realhtml = myhtmltitle+"<br><br><br>"+info+"<br><br><br>"+myhtmlcontent;
			//$("#result").replaceWith(realhtml);
	 		$("#result").html(realhtml);
		}
		 
		 
		 
		 
	 })
	 
 }
	

	




</script>
<h1>${newscompany }</h1><br>
<div id="result" class="article"></div>



