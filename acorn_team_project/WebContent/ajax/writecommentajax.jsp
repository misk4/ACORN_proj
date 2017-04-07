<%@page import="com.article.controller.Articleservice"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String content = request.getParameter("v1");
String userid = request.getParameter("v2");
String link = request.getParameter("v3");
HashMap<String,String> map = new HashMap<>();
map.put("content", content);
map.put("userid", userid);
map.put("link", link);
Articleservice service = new Articleservice();
service.writecomment(map);

%>
