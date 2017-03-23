<%@page import="com.entity.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>
	<form action="BoardWrite" method="post" enctype="multipart/form-data">
	<table width="700" border="3" bordercolor="lightgray" align="center">
        <tr>
            <td>분  류</td>
            <td colspan="3"><select name="category">
			<option value="공지사항">공지사항</option>
			<option value="잡담">잡담</option>
			<option value="정보">정보</option>
		</select>
		</td>
            <td>제목</td>
            <td colspan="5">
            <input name="title" type="text" size="30" maxlength="50" value=""/>
            </td>
        </tr>
            <tr>
            <td>작성자</td>
            <td colspan="3">
                <input name="writer_id" type="text" >
            </td>       
             
        </tr>
        <tr>
            <td >
                내 용
            </td>
            <td colspan="5">
                <textarea name="content" cols="72" rows="20"></textarea>            
            </td>        
        </tr>
        <tr>
            <td id="title" >
                파일첨부
            </td>
            <td>
                <input type="file" name="filepath" >
            </td>    
        </tr>
 
        <tr align="center" valign="middle">
            <td colspan="7">
                <input type="reset" value="작성취소" >
                <input type="submit" value="등록" >
                <input type="button" value="목록" >            
            </td>
        </tr>
    </table>    
		</form>
	<!-- </form> -->
</body>
</html>