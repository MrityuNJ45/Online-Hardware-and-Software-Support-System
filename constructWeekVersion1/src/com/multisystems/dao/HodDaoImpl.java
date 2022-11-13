package com.multisystems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.multisystems.bean.Engineer;
import com.multisystems.bean.Problem;
import com.multisystems.exceptions.EngineerException;
import com.multisystems.exceptions.ProblemException;
import com.multisystems.utility.DBUtil;

public class HodDaoImpl implements HodDao {

	@Override
	public String registerNewEngineer(Engineer e) {

		String message = "Not added...";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into Engineer values (?,?,?,?,?)");

			ps.setInt(1, e.getEngId());
			ps.setString(2, e.getEngName());
			ps.setString(3, e.getEngDept());
			ps.setString(4, e.getUsername());
			ps.setString(5, e.getPassword());

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "Engineer Registered Successfully...";
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return message;
	}

	@Override
	public List<Engineer> getAllEngineers() throws EngineerException {
		
		List<Engineer> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Engineer");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("engId");
				String name = rs.getString("engName");
				String dept = rs.getString("dept");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				Engineer e = new Engineer(id,name,dept,username,password);
				list.add(e);
				
				
			}
			
			
		} catch (SQLException ex) {
			throw new EngineerException(ex.getMessage());
		}
		
		
		if(list.size() < 1) {
			throw new EngineerException("No record found...");
		}
		
		
		return list;
	}

	@Override
	public String deleteEngineerById(int n) throws EngineerException {
		
		String message = "Not deleted...";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from Engineer where engId = ?");
			ps.setInt(1, n);
			
			int i = ps.executeUpdate();
			if(i > 0) {
				message = "Engineer deleted successfully...";
			}
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		
		
		
		
		return message;
	}

	@Override
	public List<Problem> getAllProblems() throws ProblemException {
		
		List<Problem> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Problems");
			
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
		
		if(list.size() < 1) {
			throw new ProblemException("No Problems Found...");
		}
		
		
		
		return list;
	}

	@Override
	public String assignProblemToEng(int eid, int pid) throws ProblemException {
		
		String message = "Not assigned..";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update problems set engId = ? where pid = ?");
			ps.setInt(1, eid);
			ps.setInt(2, pid);
			
			int i = ps.executeUpdate();
			
			if(i > 0) {
				message = "Problem assigned..";
			}
			
		} catch (SQLException e) {
			
			throw new ProblemException(e.getMessage());
			
		}
		
		
		return message;
	}

}
