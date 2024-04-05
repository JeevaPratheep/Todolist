<%@page import="userDTO.Task"%>
<%@page import="java.util.List"%>
<%@page import="dao.Dao"%>
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
	background-image: url("https://cdn.pixabay.com/photo/2022/06/20/14/20/space-7273891_1280.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	color: white;
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
table,tr,td,th {
border: 1px solid black;
border-collapse: collapse;


}
td {
	width: 200px;
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

<div id="tasks">
<h3>Tasks</h3>
<br>
 <table>
 <tr>  
 <th>#</th>
 <th>Title</th>
 <th>Description</th>
 <th>Priority</th>
 <th>Due Date</th>
 <th>Status</th>
 <th>Delete</th>
 </tr>
<%List<Task> tasks=(List)request.getAttribute("tasks"); %> 
 <%
 int n=1;
 int t=tasks.size();
 if(t>0){
 	for(Task task:tasks){ 
 %>
 <tr>
 <td>
<%= n %>
 
 </td>
 <td>
 <%= task.getTasktitle() %>
 
 </td>
 <td>
  <%= task.getTaskdesc() %>
 
 </td>
 <td> ,
<%= task.getTaskpriority() %>
 
 </td>
 <td>
 <%= task.getTaskduedate() %>
 
 </td>
 <td>
 <%= task.getTaskstatus() %>
 
 </td>
 
 <td><a href="delete?taskid=<%= task.getTaskid() %>" >Delete</a></td>
 
  <td><a href="edit?taskid=<%= task.getTaskid() %>" >Edit</a></td>
 </tr>
 <%
 n++;
 	}
 } 
 else{
 %>
 
 <h4>Empty</h4>

 <%} %>
 
 </table>	
</div>

</div>
</body>
</html>