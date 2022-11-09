package com.multisystems.bean;

public class Employee {

	private int eid;
	private String ename;
	private String dept;
	private String username;
	private String password;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", dept=" + dept + ", username=" + username + ", password="
				+ password + "]";
	}
	public Employee(int eid, String ename, String dept, String username, String password) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.dept = dept;
		this.username = username;
		this.password = password;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
