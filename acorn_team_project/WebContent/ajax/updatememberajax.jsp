<%@page import="com.service.MemberService"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String[] params = request.getParameter("v1").split(",");
HashMap<String,String> map = new HashMap<>();
MemberService service = new MemberService();
for(String param:params){
	String[] array = param.split(":"); 	
	map.put(array[0],array[1]);
}
service.updatememberfrommanager(map);

%>




</body>
</html>