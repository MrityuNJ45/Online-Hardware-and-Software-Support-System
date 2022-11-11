package com.multisystems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.multisystems.bean.Problem;
import com.multisystems.exceptions.ProblemException;
import com.multisystems.utility.DBUtil;

public class EngineerDaoImpl implements EngineerDao{

	@Override
	public List<Problem> getProblemByEngineer(String uname) throws ProblemException {
		
		List<Problem> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select eId from employee where username = ?");
			
			ps.setString(1, uname);
			
			ResultSet rs = ps.executeQuery();
			
			int i = 0 ;
			if(rs.next()) {
				
				i = rs.getInt("eid");
				
			}
			
			ps = conn.prepareStatement("select * from problems where empId = ?");
			ps.setInt(1, i);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("pid");
				String name = rs.getString("pname");
				String desc = rs.getString("pdesc");
				String type = rs.getString("ptype");
				int eid = rs.getInt("empId");
				int engId = rs.getInt("engId");
				boolean solved = rs.getBoolean("solved");
				
				Problem p = new Problem(id,name,desc,type,eid,engId,solved);
				list.add(p);
				
			}
			
			
		} catch (SQLException e) {
			throw new ProblemException(e.getMessage());
		}
		
		if(list.size() < 1) {
			throw new ProblemException("No Records found...");
		}
		
		
		return list;
	}

	@Override
	public String updateSolveStatus(int pid) throws ProblemException {
		
		String message = "Not Updated...";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update problems set solved = ? where pid = ?");
			System.out.println("Update Status :");
			System.out.println("1. true");
			System.out.println("2. false");
			
			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			
			if(i == 1) {
				ps.setBoolean(1, true);
			}else {
				ps.setBoolean(1, false);
			}
			
			
			ps.setInt(2, pid);
			int r = ps.executeUpdate();
			
			if(r > 0) {
				message = "Record Updated...";
			}else {
				throw new ProblemException("No record found...");
			}
			
		} catch (SQLException e) {
			throw new ProblemException(e.getMessage());
		}
		
		
		return message;
	}

}
