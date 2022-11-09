package com.multisystems.usecases;

import java.util.List;

import com.multisystems.dao.HodDaoImpl;
import com.multisystems.exceptions.ProblemException;
import com.multisystems.bean.Problem;

public class GetAllProblems {

	public static void main(String[] args) {
		
		
		System.out.println("While the Problems are loading...");
		
		HodDaoImpl dao = new HodDaoImpl();
		try {
			List<Problem> list = dao.getAllProblems();
			list.forEach(s -> {
				System.out.println("Problem Id : " + s.getPid());
				System.out.println("Problem name : " + s.getPname());
				System.out.println("Problem description : " + s.getPdesc());
				System.out.println("Problem type : " + s.getPtype());
				System.out.println("Employee Id : " + s.getEmpId());
				System.out.println("EngineerID : " + s.getEngId());
				System.out.println("===========================");
				
			});
		} catch (ProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
