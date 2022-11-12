package com.multisystems.usecases;

import com.multisystems.bean.Problem;
import com.multisystems.dao.EmployeeDaoImpl;
import com.multisystems.exceptions.ProblemException;

public class RegisterComplainUsecase {

	public static void main(String[] args) {
		
		Problem p = new Problem();
		p.setPname("Broken button");
		p.setPdesc("Display broken");
		p.setEmpId(14);
		p.setPtype("Hardware");
		
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		try {
			int i = dao.registerComplain(p);
			System.out.println(i);
		} catch (ProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
