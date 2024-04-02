package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import controller.LoginUser;
import userDTO.Task;
import userDTO.userdetails;

public class Dao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist?user=root&password=root");
		return con;
		
	}
	public static int saveUser(userdetails user) throws ClassNotFoundException, SQLException {
		Connection con = Dao.getConnection();
		PreparedStatement pst= con.prepareStatement("insert into user values(?,?,?,?,?,?)");
		pst.setInt(1, user.getUserID());
		pst.setString(2, user.getUserName());
		pst.setString(3, user.getUserEmail());
		pst.setLong(4, user.getUserContact());
		
		pst.setBlob(5,new SerialBlob(user.getUserImage()));
		pst.setString(6, user.getUserPassword());
		
		int n=pst.executeUpdate();
		return n;
	}
	public userdetails findmydetails(String email) throws SQLException, ClassNotFoundException {
		Connection con=getConnection();
		PreparedStatement pst= con.prepareStatement("select * from user where Useremail=?");
		pst.setString(1,email);
		ResultSet res=pst.executeQuery();
		if(res.next())
		{
			userdetails u= new userdetails();
			u.setUserID(res.getInt(1));
			u.setUserName(res.getString(2));
			u.setUserEmail(res.getString(3));
			u.setUserContact(res.getLong(4));
			u.setUserPassword(res.getString(6));
			Blob imageblob=res.getBlob(5);
			byte[] image =imageblob.getBytes(1, (int)imageblob.length());
			u.setUserImage(image);
			return u;
		}
		else {
			return null;
		}
	}
	public int createtask(Task task) throws ClassNotFoundException, SQLException {
		Connection con= getConnection();
		PreparedStatement pst=con.prepareStatement("insert into task values(?,?,?,?,?,?,?)");
		pst.setInt(1, task.getTaskid());
		pst.setString(2, task.getTasktitle());
		pst.setString(3, task.getTaskdesc());
		pst.setString(4, task.getTaskpriority());
		pst.setString(5, task.getTaskduedate());
		pst.setString(6, task.isTaskstatus());
		pst.setInt(7, task.getUserid());
		
		int res=pst.executeUpdate();
		return res;
	}

}
