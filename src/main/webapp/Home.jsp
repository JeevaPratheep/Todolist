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

</style>
</head>
<body>

<% userdetails u = (userdetails)request.getSession().getAttribute("user");%>
<% byte[] img=u.getUserImage();
	String image=new String(Base64.getEncoder().encode(img));
	%>
	<img alt="" src="data:image/jpeg;base64,<%=image%>" width="150" height="100">
	
<h1>Hello <%= u.getUserName() %> </h1>
<h1> E-mail: <%= u.getUserEmail()%> </h1>


<a href="addtask.jsp">Add Task</a>
</body>
</html>