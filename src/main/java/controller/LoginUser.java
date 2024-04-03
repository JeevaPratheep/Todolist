package controller;

import java.io.IOException;
import java.sql.ResultSet;
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
@WebServlet("/verify")
public class LoginUser extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("umail");
		String pass=req.getParameter("upass");
	
		Dao dao=new Dao();
		try {
			userdetails u= dao.findmydetails(email);
			
			if(u!=null) {
				
				if (u.getUserPassword().equals(pass)) {
					List<Task> tasks=dao.gettasks(u.getUserID());
					req.getSession().setAttribute("user", u);
					req.setAttribute("tasks", tasks);
					
					req.getRequestDispatcher("Home.jsp").include(req, resp);
				}
				else {
					req.setAttribute("message", "Password is Wrong");
					req.getRequestDispatcher("Login.jsp").include(req, resp);
				}
			}
			else {
				req.setAttribute("message", "Wrong E-mail");
				req.getRequestDispatcher("Login.jsp").include(req, resp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
