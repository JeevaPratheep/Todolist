package userDTO;

public class Task {
 public String getTaskstatus() {
		return taskstatus;
	}
private int taskid;
 private String tasktitle;
 private String taskdesc;
 private String taskpriority;
 private String taskduedate;
 private String taskstatus;
 private int userid;
 
 
public Task(int taskid, String tasktitle, String taskdesc, String taskpriority, String taskduedate, String taskstatus,
		int userid) {
	super();
	this.taskid = taskid;
	this.tasktitle = tasktitle;
	this.taskdesc = taskdesc;
	this.taskpriority = taskpriority;
	this.taskduedate = taskduedate;
	this.taskstatus = taskstatus;
	this.userid = userid;
}
public int getTaskid() {
	return taskid;
}
public void setTaskid(int taskid) {
	this.taskid = taskid;
}
public String getTasktitle() {
	return tasktitle;
}
public void setTasktitle(String tasktitle) {
	this.tasktitle = tasktitle;
}
public String getTaskdesc() {
	return taskdesc;
}
public void setTaskdesc(String taskdesc) {
	this.taskdesc = taskdesc;
}
public String getTaskpriority() {
	return taskpriority;
}
public void setTaskpriority(String taskpriority) {
	this.taskpriority = taskpriority;
}
public String getTaskduedate() {
	return taskduedate;
}
public void setTaskduedate(String taskduedate) {
	this.taskduedate = taskduedate;
}
public String isTaskstatus() {
	return taskstatus;
}
public void setTaskstatus(String taskstatus) {
	this.taskstatus = taskstatus;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
 
 
}
