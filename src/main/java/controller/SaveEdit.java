package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import userDTO.Task;
import userDTO.userdetails;
@WebServlet("/edittask")
public class SaveEdit extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int taskid= Integer.parseInt(req.getParameter("taskid"));
	String tasktitle =req.getParameter("tasktitle");
	String taskdesc =req.getParameter("taskdesc");
	String oldpriority = req.getParameter("oldtaskpriority");
	String taskpriority =req.getParameter("taskpriority");
	String taskdate =req.getParameter("taskdate");
	String taskstatus =req.getParameter("taskstatus");
	userdetails u= (userdetails)req.getSession().getAttribute("user");
	
	int userid=u.getUserID();
	Task task= new Task(taskid, tasktitle, taskdesc, oldpriority, taskdate, taskstatus, userid);
	if(taskpriority!=null) {
		task.setTaskpriority(taskpriority);
	}
	
	Dao dao= new Dao();
	
	try {
		dao.saveEdit(task);
		List<Task> tasks=dao.gettasks(u.getUserID());
		req.getSession().setAttribute("user", u);
		req.setAttribute("tasks", tasks);
		req.getRequestDispatcher("Home.jsp").include(req, resp);
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
}
}
