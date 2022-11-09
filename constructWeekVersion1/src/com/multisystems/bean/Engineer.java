package com.multisystems.bean;

public class Engineer {

	private int engId;
	private String engName;
	private String engDept;
	private String username;
	private String password;

	public Engineer(int engId, String engName, String engDept, String username, String password) {
		super();
		this.engId = engId;
		this.engName = engName;
		this.engDept = engDept;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Engineer [engId=" + engId + ", engName=" + engName + ", engDept=" + engDept + ", username=" + username
				+ ", password=" + password + "]";
	}

	public int getEngId() {
		return engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getEngDept() {
		return engDept;
	}

	public void setEngDept(String engDept) {
		this.engDept = engDept;
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

	public Engineer() {
		// TODO Auto-generated constructor stub
	}
}
