<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

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