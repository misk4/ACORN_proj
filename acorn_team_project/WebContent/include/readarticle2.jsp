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
			   //var pubDate = $(this).find("pubDate").text();
			   var aa2 = "<a href='javascript:void(0)' onclick='ormSubmit("+idx+"); '>"
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
 
 
 
	
function ormSubmit(idx){
	 
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
			
			var aa = $.parseHTML(responsData.trim());
	 		var myhtmltitle = $(aa).find(".subject").text();
	 		var info = $(aa).find(".byline").text();
	 		var myhtmlcontent = $(aa).find("#article_body").text();
	 		var input = "<input type='hidden' id='link' name='link' value='"+xx+"'>"
	 		var realhtml = input+myhtmltitle+"<br><br><br>"+info+"<br><br><br>"+myhtmlcontent+"<br><br><br>"
	 		+"<button onclick='viewcomment()'>댓글보기</button>"
	 		$("#result").html(realhtml);

	 		
	 		
	 		
	 		
		}
		 
		 
	 })
	 
}

	



function viewcomment(){
	
	var x = document.getElementById("link");
	var xx = x.value;
	
	
	 $.ajax({
		type:"get",
		url:"ajax/getcommentajax.jsp",
		data:{
			v1:xx
			
		},
		dataType : "text",
		success: function(responsData,status,xhr){
			
			var text = "<textarea id='content' name='content' cols='5' style='width:50%;'></textarea>"
			var button = "<button onclick='writecomment()'>등록</button>"

			$("#articlecomment").html(responsData+"<br><br><br>");
			$("#writecomment").append(text+button);
			
		
	 		
	 		
	 		
	 		
		}
		 
		 
	 })
	
}


function writecomment(){
	
	var x = document.getElementById("link");
	var link = x.value;
	var commentcontent = $("#content").val();
	var userid = $("#userid").val();
	$.ajax({
		type:"get",
		url:"ajax/writecommentajax.jsp",
		data:{
			v1:commentcontent,
			v2:userid,
			v3:link
			
		},
		dataType : "text",
		success: function(responsData,status,xhr){
		
		$("#articlecomment").find("ul").append("<li>"+"작성자:"+userid+"내용:"+commentcontent+"</li>");			
		
	 		
	 		
	 		
	 		
		}
		 
		 
	 })
	
	
}


</script>




<h1>${newscompany }</h1><br>
<div id="result" class="article"></div>


<div id="articlecomment"></div>
<div id="writecomment">
<input type="hidden" value="${userid.id }" id="userid">
</div>














