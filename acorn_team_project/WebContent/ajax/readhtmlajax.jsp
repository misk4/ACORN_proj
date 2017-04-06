<%@page import="java.util.HashMap"%>
<%@page import="com.article.controller.Articleservice"%>
<%@page import="com.entity.NewsArticleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String link = request.getParameter("v1");
Articleservice service = new Articleservice();
HashMap<String,String> map = new HashMap<>();
map.put("link", link);
String myhtml = service.urlreader(map);

%>
<%=myhtml%>

