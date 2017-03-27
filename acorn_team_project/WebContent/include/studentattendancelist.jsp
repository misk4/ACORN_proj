<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 
uri="http://java.sun.com/jsp/jstl/functions" %> 
	
 <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>출석일</th>
        <th>출석시간</th>
        
      </tr>
    </thead>
    <c:forEach var ="list" items="${list}">
    <tbody>
      <tr>
        <td>${list.student_id }</td>
        <td>${list.name }</td>
        <td>${list.course_date }</td>
        <td>${list.tag_time }</td>
      
      </tr>
    </tbody>
    </c:forEach>
  </table>
  </div>
  
  <a href="AbsenceStudentlist" class="btn btn-success" role="button">출석하지않은인원확인하기</a>
