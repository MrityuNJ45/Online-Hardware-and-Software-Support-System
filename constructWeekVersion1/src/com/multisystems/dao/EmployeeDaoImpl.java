package com.multisystems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.multisystems.bean.Employee;
import com.multisystems.exceptions.EmployeeException;
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

}
