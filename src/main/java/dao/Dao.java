package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
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
	public List<Task> gettasks(int userid) throws ClassNotFoundException, SQLException{
		Connection con=getConnection();
		
		PreparedStatement pst=con.prepareStatement("select * from task where userid = ?");
		pst.setInt(1, userid);
		ResultSet rs=pst.executeQuery();
		List<Task> tasks=new ArrayList<>();
//		if (rs.next()) {
			while(rs.next()) {
				Task task=new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), userid);
				tasks.add(task);	
			}
			return tasks;
//		}
//		else {
//			return null;
//		}
	}
	public int deletetask(int taskid) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst=con.prepareStatement("DELETE FROM task WHERE taskid=?");
		pst.setInt(1, taskid);
		int res=pst.executeUpdate();
		return res;
		
	}
	public int getTaskid() throws ClassNotFoundException, SQLException
	{
		Connection con=  getConnection();
		PreparedStatement pst=con.prepareStatement("select max(taskid) from task");
		ResultSet rs=pst.executeQuery();
		if(rs.next()) {
			int id=rs.getInt(1);
			return id+1;
		}
		else {
			return 1;
		}
	}
	
	public int getUserid() throws ClassNotFoundException, SQLException
	{
		Connection con=  getConnection();
		PreparedStatement pst=con.prepareStatement("select max(UserID) from user");
		ResultSet rs=pst.executeQuery();
		if(rs.next()) {
			int id=rs.getInt(1);
			return id+1;
		}
		else {
			return 1;
		}
	}
	public Task editTask(int taskid,int userid) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst=con.prepareStatement("select * from task where taskid = ?");
		pst.setInt(1, taskid);
		ResultSet rs= pst.executeQuery();
		
		if(rs.next()) {
			Task task=new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), userid);
			return task;
		}
		else
		{
			return null;
		}
		
		
		
		
	}
	
	public int saveEdit(Task task) throws ClassNotFoundException, SQLException {
		Connection con =getConnection();
		PreparedStatement pst= con.prepareStatement("UPDATE task SET tasktitle = ?, taskdesc = ?, taskpriority = ?, taskduedate = ?, taskstatus = ? WHERE taskid = ?");
		pst.setString(1, task.getTasktitle());
		pst.setString(2, task.getTaskdesc());
		pst.setString(3, task.getTaskpriority());
		pst.setString(4, task.getTaskduedate());
		pst.setString(5, task.getTaskstatus());
		pst.setInt(6, task.getTaskid());
		int res=pst.executeUpdate();
		return res;
	}
}
