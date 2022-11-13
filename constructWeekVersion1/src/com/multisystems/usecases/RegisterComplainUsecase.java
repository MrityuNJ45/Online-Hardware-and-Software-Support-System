package com.multisystems.usecases;

import java.util.Scanner;

import com.multisystems.bean.Problem;
import com.multisystems.dao.EmployeeDaoImpl;
import com.multisystems.exceptions.ProblemException;

public class RegisterComplainUsecase {

	public static void main(String[] args) {
		
		Problem p = new Problem();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Problem type : ");
		System.out.println("1. Hardware");
		System.out.println("2. Software");
		
		int i = sc.nextInt();
		if( i == 1) {
			p.setPtype("Hardware");
		}else {
			p.setPtype("Software");
		}
		System.out.println("Enter Problem Name : ");
		String name = sc.next();
		
		p.setPname(name);
		
		System.out.println("Enter Problem Descripton : ");
		String desc = sc.next();
		p.setPdesc(desc);
		System.out.println("Enter Employee Id : ");
		int eid = sc.nextInt();
		p.setEmpId(eid);
		
		
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		try {
			int ii = dao.registerComplain(p);
			
			System.out.println("Your Problem ID : "+ii);
		} catch (ProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
