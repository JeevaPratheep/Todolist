<%@page import="userDTO.Task"%>
<%@page import="userDTO.userdetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-image: url("https://cdn.pixabay.com/photo/2017/03/05/12/06/bamboo-2118470_1280.jpg");
background-repeat: no-repeat;
background-size: cover;
color: rgb(0,0,0);
}
fieldset {
	
	border: none;
	margin-top: 1cm;
	line-height: 80px;
	}
</style>
</head>
<body>
<fieldset >
<table>
	<legend>
		<h1>Edit task</h1>
	<form action="edittask" method="post">
		<% userdetails u = (userdetails)request.getSession().getAttribute("user");%>
		<%Task task=(Task)request.getAttribute("task");%>
		<tr>
		<td>
	
		</td>
		<td><input type="text" name="taskid" required value=<%=task.getTaskid() %> readonly="readonly" hidden="hidden"> </td>
		</tr>
		<tr>
		<td>
		Task Title :
		</td>
		<td><input type="text" name="tasktitle" required value=<%=task.getTasktitle()%>></td>
		</tr>
		<tr>
		<td>
		Task Description :
		</td>
		<td><input type="text" name="taskdesc" required value=<%= task.getTaskdesc()%>></td>
		</tr>
		<tr>
		<td>
		Task Priority :
		</td>
		<td>
		<input type="text" name="oldtaskpriority" value="<%= task.getTaskpriority()%>">
		</td>
		<td><input type="radio" name="taskpriority" value="low">Low priority
			<input type="radio" name="taskpriority" value="medium">Medium priority
			<input type="radio" name="taskpriority" value="high">High priority
		</td>
		</tr>
		<tr>
		<td>
		Task Due Date :
		</td>
		<td><input type="date" name="taskdate" value=<%=task.getTaskduedate() %>>></td>
		
		
		</tr>
		
		<tr>
		<td>Task Status :</td>
		<td><input type="text" name="taskstatus" required value=<%=task.getTaskstatus() %>></td>
		</tr>
		<tr>
		<td>
		
		</td>
		<td><input type="submit"></td>
		</tr>
	</form>
</table>
</legend>
</fieldset>

</body>
</html>