package controller;

import java.io.IOException;
import java.sql.SQLException;

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
	
		int taskid= Integer.parseInt(req.getParameter("taskid"));
		String tasktitle =req.getParameter("tasktitle");
		String taskdesc =req.getParameter("taskdesc");
		String taskpriority =req.getParameter("taskpriority");
		String taskdate =req.getParameter("taskdate");
		userdetails u= (userdetails)req.getSession().getAttribute("user");
		
		int userid=u.getUserID();
		Task task= new Task(taskid, tasktitle, taskdesc, taskpriority, taskdate, "pending",userid);
		
		Dao dao= new Dao();
		
		try {
			
			int res=dao.createtask(task);
			
			if(res>0) {
				
				resp.getWriter().print("Task added");
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
