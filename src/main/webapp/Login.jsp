<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<style type="text/css">

body{
background-image: url("https://cdn.pixabay.com/photo/2015/12/01/15/43/black-1072366_1280.jpg");
background-repeat: no-repeat;
background-size: cover;
color: rgb(430,230,130);
}
fieldset {
	margin-left: 14cm;
	margin-top: 5cm;
	margin-right: 14cm;
}
</style>
</head>
<body>
<fieldset >
<table>
	<legend>
		<h1>Login</h1>
	<form action="verify" method="post" enctype="application/x-www-form-urlencoded">
	
		<tr>
		<td>
		User-Email :
		</td>
		<td><input type="text" name="umail"></td>
		</tr>
		<tr>
		<td>
		Password :
		</td>
		<td><input type="text" name="upass"></td>
		</tr>
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