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

@WebServlet("/addtask")
public class AddTask extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//		int taskid= Integer.parseInt(req.getParameter("taskid"));
		String tasktitle =req.getParameter("tasktitle");
		String taskdesc =req.getParameter("taskdesc");
		String taskpriority =req.getParameter("taskpriority");
		String taskdate =req.getParameter("taskdate");
		userdetails u= (userdetails)req.getSession().getAttribute("user");
		
		
		
		try {
			int userid=u.getUserID();
			Dao dao= new Dao();
			Task task= new Task(dao.getTaskid(), tasktitle, taskdesc, taskpriority, taskdate, "pending",userid);
			
		
			int res=dao.createtask(task);
			
			if(res>0) {
				
				List<Task> tasks=dao.gettasks(u.getUserID());
				req.getSession().setAttribute("user", u);
				req.setAttribute("tasks", tasks);
				req.getRequestDispatcher("Home.jsp").include(req, resp);
			}
			else {
				req.getRequestDispatcher("failed");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
