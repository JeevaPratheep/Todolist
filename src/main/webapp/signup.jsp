<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUP</title>
<style type="text/css">
fieldset {
	margin-left: 15cm;
	margin-top: 5cm;
	margin-right: 15cm;
}
</style>
</head>
<body>
<fieldset >
<table>
	<legend>
		<h1>Sign UP</h1>
	<form action="signup" method="post" enctype="multipart/form-data">
	
		<tr>
		<td>
		ID :
		</td>
		<td><input type="text" name="id"></td>
		</tr>
		<tr>
		<td>
		Name :
		</td>
		<td><input type="text" name="name"></td>
		</tr>
		<tr>
		<td>
		E-mail :
		</td>
		<td><input type="email" name="email"></td>
		</tr>
		<tr>
		<td>
		Contact :
		</td>
		<td><input type="text" name="contact"></td>
		</tr>
		<tr>
		<td>
		Password :
		</td>
		<td><input type="text" name="password"></td>
		</tr>
		<tr>
		<td>
		Image :
		</td>
		<td><input type="file" name="image"></td>
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