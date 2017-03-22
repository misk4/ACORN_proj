<%@page import="com.entity.MemberDTO"%>
<%@page import="com.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("v1");
MemberService service = new MemberService();
int k = service.idcheck(id);

%>
<%=k %>

