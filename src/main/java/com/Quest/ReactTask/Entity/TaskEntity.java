package com.Quest.ReactTask.Entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "taskcollection")
public class TaskEntity {

	public static final String sqe_name="task_name";
	
	@Id
	private int id;
	private String tname;
	private String tdesc;
	private String tstatus;
	public String getTstatus() {
		return tstatus;
	}
	public void setTstatus(String tstatus) {
		this.tstatus = tstatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTdesc() {
		return tdesc;
	}
	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}
	@Override
	public String toString() {
		return "TaskEntity [id=" + id + ", tname=" + tname + ", tdesc=" + tdesc + ", tstatus=" + tstatus + "]";
	}
	
	
}
