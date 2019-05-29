<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <form action="AddTeacher" method="POST"> 
		Id:<input type="text" name="id"><br>
		Name:<input type="text" name="name"><br>
		Salary:<input type="text" name="salary"><br>
		Sex:<input type="text" name="sex"><br>
		Birthday:<input type="date" name="birthday"><br>
		College:<input type="text" name="college"><br>
		Major:<input type="text" name="major"><br>
		<input type="submit" id="login-button" value="新增"><br>
	 </form> 
</body>
</html>