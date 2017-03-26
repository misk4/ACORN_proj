<%@page import="com.entity.StudentDTO"%>
<%@page import="com.service.CalendarService"%>
<%@page import="com.entity.AttendanceDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.service.AttendanceService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String mm = CalendarService.getmm();
StudentDTO dto2 =(StudentDTO)session.getAttribute("userid");
String id = dto2.getId();
HashMap<String,String> map = new HashMap<>();
map.put("mm", mm);
map.put("student_id",id);
AttendanceService service = new AttendanceService();
List<AttendanceDTO> list = service.getattendancedate(map);
String attendancedate = "";
for(AttendanceDTO dto:list){
	String test = dto.getCourse_date().substring(0, 10);
	attendancedate+=test+",";
	
}

%>
<%=attendancedate %>




