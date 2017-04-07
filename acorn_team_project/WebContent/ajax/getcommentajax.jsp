<%@page import="com.entity.ArticleCommentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.article.controller.Articleservice"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 
uri="http://java.sun.com/jsp/jstl/functions" %> 
<%

String link = request.getParameter("v1");
HashMap<String,String> map = new HashMap<>();
map.put("link", link);
Articleservice service = new Articleservice();
List<ArticleCommentDTO> list = service.getarticlecommentlist(map);
pageContext.setAttribute("list", list);
%>
<ul>

<c:forEach var="aa" items="${list }">
<li>작성자:${aa.author}내용:${aa.content }</li>
</c:forEach>

</ul>	