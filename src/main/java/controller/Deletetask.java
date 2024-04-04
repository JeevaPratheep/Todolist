package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.UserDataHandler;

import dao.Dao;
import userDTO.Task;
import userDTO.userdetails;

@WebServlet("/delete")
public class Deletetask extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("taskid"));
		Dao dao=new Dao();
		userdetails u= (userdetails)req.getSession().getAttribute("user");
		try {
			int res=dao.deletetask(id);
			List<Task> tasks=dao.gettasks(u.getUserID());
			req.getSession().setAttribute("user", u);
			req.setAttribute("tasks", tasks);
			req.getRequestDispatcher("Home.jsp").include(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
