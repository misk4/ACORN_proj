<%@page import="com.entity.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberService service = new MemberService();
List<MemberDTO> list = service.watingjoinlist();
%>
<%=list.size()%>