<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateArticleCategory">
<div class="radio">
  <label><input type="radio" name="category" value="스포츠">스포츠</label>
</div>
<div class="radio">
  <label><input type="radio" name="category" value="IT">과학IT</label>
</div>
<div class="radio">
  <label><input type="radio" name="category" value="경제">경제</label>
</div><br>

<input type="submit" value="변경">
</form>

</body>
</html>