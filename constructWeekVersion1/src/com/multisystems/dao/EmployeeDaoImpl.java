package com.multisystems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.multisystems.bean.Employee;
import com.multisystems.bean.Problem;
import com.multisystems.exceptions.EmployeeException;
import com.multisystems.exceptions.EngineerException;
import com.multisystems.exceptions.ProblemException;
import com.multisystems.utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String registerEmployee(Employee e) throws EmployeeException {
		
		String message = "Not Registered....";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into problems values (?,?,?,?,?)");
			ps.setInt(1, e.getEid());
			ps.setString(2, e.getEname());
			ps.setString(3, e.getDept());
			ps.setString(4, e.getUsername());
			ps.setString(5, e.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Employee Registered Successfully...";
			}
			
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		return message;
	}
      @Override
	public int registerComplain(Problem p) throws ProblemException {
		
		int id = 0;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into problems (pname,pdesc,ptype,empId) values (?,?,?,?)");
			
			ps.setString(1, p.getPname());
			ps.setString(2,p.getPdesc());
			ps.setString(3, p.getPtype());
			ps.setInt(4, p.getEmpId());
			
			int x = ps.executeUpdate();
			if(x > 0) {
				
				ps = conn.prepareStatement("select last_insert_id()");
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					id = rs.getInt("last_insert_id()");
				}
				
			}
			
			
			
		} catch (SQLException e) {
			throw new ProblemException(e.getMessage());
		}
		
		
		return id;
	}
	@Override
	public String getProblemStatus(int id) throws ProblemException {
		
		String name = "Not got...";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select engId from problems where pid = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int i = rs.getInt("engId");
				ps = conn.prepareStatement("select engName from engineer where engId = ?");
				ps.setInt(1, i);
				ResultSet rs1 = ps.executeQuery();
				if(rs1.next()) {
					name = rs1.getString("engName");
				}
			}
			
			
			
			
		} catch (SQLException e) {
			throw new ProblemException(e.getMessage());
		}
		
		
		
		
		return name;
	}
	@Override
	public List<Problem> getProblemsById(int id) throws ProblemException {
		
		List<Problem> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from problems where empId = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				int i = rs.getInt("pid");
				String name = rs.getString("pname");
				String desc = rs.getString("pdesc");
				String type = rs.getString("ptype");
				int eid = rs.getInt("empId");
				int engId = rs.getInt("engId");
				boolean solved = rs.getBoolean("solved");
				
				Problem p = new Problem(i,name,desc,type,eid,engId,solved);
				list.add(p);
				
			}
			
			
		} catch (SQLException e) {
			throw new ProblemException(e.getMessage());
		}
		
		if(list.size() == 0) {
			throw new ProblemException("No record found...");
		}
		
		
		return list;
		
	}
	
	
	
	

}
