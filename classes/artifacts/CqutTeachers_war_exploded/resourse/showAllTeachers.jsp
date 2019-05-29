<%@page import="edu.cqut.hr.entity.Teacher" %>
<%@page import ="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"
 	                   +request.getServerPort()+path+"/";
 	
 	
	List<Teacher> teachers = (List<Teacher>)request.getAttribute("teacherList");
 %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=basePath%>">
    <title>showAllTeachers</title>
	<link rel="stylesheet" href="showAllTeachers.css">
    <script type="text/javascript" src="showAllTeachers.js"></script>
</head>
<body>
	<tr><h3>-------------------教职工管理系统---------------------</h3></tr><td></td>
   	<table border="1">	
		<tr>
		<td><strong>id</strong></td><td></td>
		<td><strong>name</strong></td><td></td>
		<td><strong>salary</strong></td><td></td>
		<td><strong>sex</strong></td><td></td>
		<td><strong>birthday</strong></td><td></td>
		<td><strong>college</strong></td><td></td>
		<td><strong>major</strong></td><td></td>
		</tr>
    	<% for(Teacher teacher : teachers) { %>
   		<tr>
   			<td><%=teacher.getId() %></td><td></td><td><%=teacher.getName() %></td><td></td>
   			<td><%=teacher.getSalary() %></td><td></td><td><%=teacher.getSex() %></td><td></td>
   			<td><%=teacher.getBirthday()%></td><td></td><td><%=teacher.getCollege() %></td><td></td>
   			<td><%=teacher.getMajor() %></td><td></td>
   		</tr>
		<% } %>   
	</table>
	
	<a href ="addTeacher.jsp">
	<button type="button">新增</button></a>
	
	<button type="button" id="update">更新</button>
	<button type="button" id="delete">删除</button>
	

	<div id="updateTeacher">
		<form action="UpdateTeacher" method="POST">
			you want to update record of <br>
			oldId:<input type="text" name="oldId" ><br>
			newID:<input type="text" name="newId"><br>
			newName:<input type="text" name="name"><br>
			newSalary:<input type="text" name="salary"><br>
			newSex:<input type="text" name="sex"><br>
			newBirthday:<input type=date name="birthday"><br>
			newCollege:<input type="text" name="college"><br>
			newMajor:<input type="text" name="major"><br>
			<input type="submit" value="确定更新">
		</form>
	</div> 
	
	<div id="deleteTeacher">
	<form action="DeleteTeacher" method="POST">
			you want to delete record of Id:<input type="text" name="deleteId" >
			<input type="submit" value="确定删除">
	</form>
	</div>

</body>
</html>