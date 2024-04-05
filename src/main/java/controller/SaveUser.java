package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Dao;
import userDTO.userdetails;
@WebServlet("/signup")
@MultipartConfig(maxFileSize=10*1024*1024)
public class SaveUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		int id=Integer.parseInt(req.getParameter("id"));
		String name= req.getParameter("name");
		String email=req.getParameter("email");
		long contact =Long.parseLong(req.getParameter("contact"));
		String password=req.getParameter("password");
		Part imagepart=req.getPart("image");
		byte[] image=imagepart.getInputStream().readAllBytes();
		Dao dao= new Dao();
		
	
		try {
			int id=dao.getUserid();
			userdetails user= new userdetails(id, name, email, contact, image, password);
			
			int res =dao.saveUser(user);
			
			if(res>0) {
				resp.sendRedirect("Login.jsp");
			}
			else {
				resp.getWriter().print("signup.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
