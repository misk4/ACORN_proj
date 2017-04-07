<%@page import="com.entity.PageDTO"%>
<%@page import="com.entity.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 
uri="http://java.sun.com/jsp/jstl/functions" %>
   



<script>
function deleteBy(id){
   
   console.log(id);

   if(confirm("삭제하시겠습니까?") == true){
      
      $(document).ready(function() {
         
         $.ajax({
            type: "get",
            url:"ajax/deleteboardajax.jsp",
            data: {
               v1:id
            },
            dataType:"text",
            success: function(responseData, status, xhr){
               $("#"+id+"").remove();
               
               
            }
         
            
         })//ajax
         
         
         
      })//end ajax jquery
      
   }//end confimr if
   
   
   
}//end function delete
</script>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>




<h1>게시판   </h1>
   <table class="table table-bordered">
      <tr>      
         <th>글번호</th>
         <th>분류</th>
         <th>제목</th>
         <th>작성자</th>
         <th>작성일</th>
         <th>조회수</th>
      </tr>
   <c:set var="pDTO" value="${pageDTO}"/>
   <c:forEach var="xxx" items="${pDTO.list}">
      <tr id="${xxx.id }">
         <td>${xxx.id}
         <c:if test="${userid.confirmation==2}">
         <button class="btn btn-danger" onclick="deleteBy('${xxx.id}')">위험글삭제</button>            
         </c:if>
         </td>
         <td>${xxx.category}</td>
         <td><a href="BoardInfo?id=${xxx.id}">${xxx.title}</a></td>
         <td>${xxx.writer_id}</td>
         <td>${xxx.written_date}</td>
         <td>${xxx.readcnt}</td>
      </tr>
   </c:forEach>
      <tr>   
         <th colspan="6" >
            <form action="BoardSearch" method="get" align="center">
               <select name="searchName">
                  <option value ="title">제목</option>
                  <option value = "writer_id">작성자</option>
               </select>
                  <input type="text" name="searchValue">
                  <input type="submit" value="검색">
            </form>
            <input type="button" value="글쓰기" onclick= "location.href='BoardWriteUi'">
         </th>
      </tr>
<!-- page --> 
  <tr>
   <td colspan="6">
       <c:set var="totalcount"
                   value="${pageDTO.totalcount}"/>
       <c:set var="curPage"
                   value="${pageDTO.curpage}"/>
       <c:set var="perpage"
                   value="${pageDTO.perpage}"/>
       <c:set var ="totalpagecount"
                   value="${totalcount/perpage}"/>
       <c:if test= "${totalcount%perpage != 0}">
          <c:set var ="totalpagecount"
                   value="${totalpagecount+1}"/>               
      </c:if>
      <c:forEach var ="i" begin ="1" end ="${totalpagecount}">
        <c:choose>
           <c:when test="${curpage==i}">
           ${i}&nbsp;
           </c:when>
         <c:otherwise>
   <a href='BoardList?curPage=${i}'>${i}</a>&nbsp;
         </c:otherwise>
         </c:choose>
         
         
         </c:forEach>
   </td>
  </tr>
 <!-- page -->  
   </table>
   <c:if test="${userid != null }">
   
   </c:if>
   