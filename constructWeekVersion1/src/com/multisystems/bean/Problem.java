package com.multisystems.bean;

public class Problem {

	private int pid;
	private String pname;
	private String pdesc;
	private String ptype;
	private int empId;
	private int engId;
	private boolean solved;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getEngId() {
		return engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
	}

	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	public Problem(int pid, String pname, String pdesc, String ptype, int empId, int engId, boolean solved) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdesc = pdesc;
		this.ptype = ptype;
		this.empId = empId;
		this.engId = engId;
		this.solved = solved;
	}

	@Override
	public String toString() {
		return "Problem [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", ptype=" + ptype + ", empId=" + empId
				+ ", engId=" + engId + ", solved=" + solved + "]";
	}

	public Problem() {
		// TODO Auto-generated constructor stub
	}

}
