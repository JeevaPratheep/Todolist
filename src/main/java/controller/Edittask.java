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
@WebServlet("/edit")
public class Edittask extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int taskid =Integer.parseInt(req.getParameter("taskid"));
		Dao dao= new Dao();
		userdetails u= (userdetails)req.getSession().getAttribute("user");
		try {
			Task task=dao.editTask(taskid);
			req.getSession().setAttribute("user", u);
			req.setAttribute("task", task);
			req.getRequestDispatcher("edit.jsp").include(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
