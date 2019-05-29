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
<!DOCTYPE html>
<html>
<head>
	<title>学生信息管理系统</title>
	<link rel="stylesheet" type="text/css" href="showTeachersInfo.css">
	<script type="text/javascript" src="showTeachersInfo.js"></script>
</head>
<body>

<!-- 相当于容器 -->
<div class="container">

	<div class="head">
		<div class="headTop">
			<div class="titleline"></div>
			<div class="title">教职工信息管理系统</div>
			<div class="titleline"></div>
		</div>

		<div class="headBottom">
			<form>	
				<input class="addDutton" type="button" value="新增" onclick="addInterface()">
				<input class="deleteDutton" type="button" value="删除" onclick="deleteInterface()" >
			</form>
		</div>
	</div>

	<div class="content">
		<table class="tab" id="tab">
			<tr class="backgroundColor1">
				<th><form><input name="allseclect" type="checkbox" id="all" onclick="allclick(all.checked)"></form></th>
				<th>Id</th><th>Name</th><th>Salary</th>
				<th>Sex</th><th>Birthday</th><th>College</th><th>Major</th><th></th>
				<th id="c9" colspan="2" onclick="creatElement()">操作</th>
			</tr>
			<% int count =1; %>
			<% for(Teacher teacher : teachers) { 
			   	 if(count%2!=0) 
			   	 { %>
					<tr class="backgroundColor2">
						<th><%teacher.getId(); %></th><th><%teacher.getName(); %></th><th><%teacher.getSalary(); %></th>
						<th><%teacher.getSex(); %></th><th><%teacher.getBirthday(); %></th><th><%teacher.getCollege(); %></th><th><%teacher.getMajor(); %></th><th></th>
						<td class="operator1" onclick="checkInterface(1)"></td>
						<td class="operator2" onclick="amendInterface(1)"></td>
					</tr>
					<% } else {	%>
					<tr class="backgroundColor1">
						
						<th><%teacher.getId(); %></th><th><%teacher.getName(); %></th><th><%teacher.getSalary(); %></th>
						<th><%teacher.getSex(); %></th><th><%teacher.getBirthday(); %></th><th><%teacher.getCollege(); %></th><th><%teacher.getMajor(); %></th><th></th>
						<td class="operator1" onclick="checkInterface(2)"></td>
					<td class="operator2" onclick="amendInterface(2)"></td>
					</tr>
					<% }
			   	count++;
			} %>
			
		</table>
	</div>
	
	<div class="footer">
		<div class="footerLeft" id="footerLeft">
		<p id="s1"></p><p id="s1"></p>
		</div>

		<div class="footerRight">
			<form>
			<input class="upDutton" type="button" onclick="lastPageBegin()" value="上一页">
			<input class="downDutton" type="button" onclick="nextPageBegin()" value="下一页">
			</form>
		</div>
	</div>

</div>

<div class="backgroundcolor" id="inter">
</div>


<!--学生信息添加界面-->
<div class="addInterface" id="addinter">
	<div class="interface-top">		
		新增学生信息
	</div>

	<div class="interface-middle">
		<form id="interface-from" action="submit">
			学号&nbsp<input id="addstudent" type="text" placeholder="例如：11603080231"><br><br>
			姓名&nbsp<input id="addname" type="text" placeholder="例如：李华"><br><br>
			学院&nbsp<input id="addcollage" type="text" placeholder="例如：计算机学院"><br><br>
			专业&nbsp<input id="addmajor" type="text" placeholder="例如：软件工程"><br><br>
			年级&nbsp<input id="addgrade" type="text" placeholder="例如：2016"><br><br>
			班级&nbsp<input id="addclass" type="text" placeholder="例如：116030802"><br><br>
			年龄&nbsp<input id="addage" type="text" placeholder="例如：20"><br><br>
		</form>
	</div>

	<div class="interface-bottom">
		<form id="after-from">
			<input class="submitDutton" type="button" value="提交" 
			onclick="judgevalue()">
			<input class="CancelDutton" type="button" value="取消" 
			onclick="CancelInterface()">
		</form>
	</div>
</div>


<!--学生信息查看界面-->
<div class="checkInterface" id="checkinter">
	<div class="interface-top">		
		查看学生信息
	</div>

	<div class="interface-middle">
		<from id="interface-from" action="submit">
			学号&nbsp<input id="checkstudent" type="text"><br><br>
			姓名&nbsp<input id="checkname" type="text"><br><br>
			学院&nbsp<input id="checkcollage" type="text"><br><br>
			专业&nbsp<input id="checkmajor" type="text"><br><br>
			年级&nbsp<input id="checkgrade" type="text"><br><br>
			班级&nbsp<input id="checkclass" type="text"><br><br>
			年龄&nbsp<input id="checkage" type="text"><br><br>
		</from>
	</div>

	<div class="interface-bottom">
		<form id="after-from">
			<input class="ensureDutton" type="button" value="返回" 
			onclick="CancelInterface()">
		</form>
	</div>
</div>


<!--学生信息修改界面-->
<div class="amendInterface" id="amendinter">
	<div class="interface-top">		
		修改学生信息
	</div>

	<div class="interface-middle">
		<from id="interface-from" action="submit">
			学号&nbsp<input id="amendstudent" type="text"><br><br>
			姓名&nbsp<input id="amendname" type="text"><br><br>
			学院&nbsp<input id="amendcollage" type="text"><br><br>
			专业&nbsp<input id="amendmajor" type="text"><br><br>
			年级&nbsp<input id="amendgrade" type="text"><br><br>
			班级&nbsp<input id="amendclass" type="text"><br><br>
			年龄&nbsp<input id="amendage" type="text"><br><br>
		</from>
	</div>

	<div class="interface-bottom">
		<form id="after-from">
			<input class="saveDutton" type="button" value="保存" 
			 onclick="amendjudgevalue()">
			<input class="CancelDutton" type="button" value="取消"
			 onclick="CancelInterface()">
		</form>
	</div>
</div>


<!--删除询问界面-->
<div class="deleteInterface" id="deleteinter">
	<div  class="deletedutton">
	<form>	
		<input class="addDutton" type="button" value="确认删除" onclick="deleteElement()">
		<input class="deleteDutton" type="button" value="取消" onclick="CancelInterface()" >
	</form>
	</div>
</div>

</body>
</html>