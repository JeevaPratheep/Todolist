<%@page import="java.awt.image.BaseMultiResolutionImage"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.util.Base64"%>
<%@page import="userDTO.userdetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style type="text/css">

body{
	background-image: url("https://cdn.pixabay.com/photo/2017/07/13/16/16/paper-2500942_960_720.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
#homepage{
	padding: 20px;
}
a{
 display:inline-block;
 text-align: center;
 border: 1px solid grey;
 width:150px;
 height: 45px;
 line-height: 40px;
 color: white;
 background-color: blue;
 text-decoration: none;
 border-radius:25px; 
 
}
a:hover {
	color: black;
	background-color: skyblue;

}
#udetails{
display: flex;
}
#image {
	width: 30%
}
#uinfo{
width: 70%
}

</style>
</head>
<body>

<div id="homepage">
<div id="udetails">
	<div id="image">
		<% userdetails u = (userdetails)request.getSession().getAttribute("user");%>
		<% byte[] img=u.getUserImage();
		String image=new String(Base64.getEncoder().encode(img));%>
		<img alt="" src="data:image/jpeg;base64,<%=image%>" width="250" height="200">
	
	</div>
	
	<div id="uinfo">
		<h1>Hello <%= u.getUserName() %> </h1>
		<h1> E-mail: <%= u.getUserEmail()%> </h1>
	
	</div>
</div>

<br>
<br>
<br>
<a href="addtask.jsp">Add Task</a>

</div>
</body>
</html>