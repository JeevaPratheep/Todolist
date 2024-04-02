<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>
<style type="text/css">
fieldset {
	margin-left: 10cm;
	margin-top: 5cm;
	margin-right: 10cm;
}
</style>

</head>
<body>
<fieldset >
<table>
	<legend>
		<h1>Add task</h1>
	<form action="addtask" method="post">
	
		<tr>
		<td>
		Task-ID :
		</td>
		<td><input type="text" name="taskid" required></td>
		</tr>
		<tr>
		<td>
		Task Title :
		</td>
		<td><input type="text" name="tasktitle" required></td>
		</tr>
		<tr>
		<td>
		Task Description :
		</td>
		<td><input type="text" name="taskdesc" required></td>
		</tr>
		<tr>
		<td>
		Task Priority :
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
		<td><input type="date" name="taskdate"></td>
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