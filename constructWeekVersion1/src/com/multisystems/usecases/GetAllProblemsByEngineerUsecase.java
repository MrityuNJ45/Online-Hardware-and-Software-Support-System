package com.multisystems.usecases;

import java.util.List;
import java.util.Scanner;

import com.multisystems.bean.Problem;
import com.multisystems.dao.EngineerDaoImpl;
import com.multisystems.exceptions.ProblemException;

public class GetAllProblemsByEngineerUsecase {

	public static void main(String[] args) {
		
		
		System.out.println("Enter username : ");
		Scanner sc = new Scanner(System.in);
		String uname = sc.next();
		
		EngineerDaoImpl dao = new EngineerDaoImpl();
		try {
			List<Problem> list = dao.getProblemByEngineer(uname);
			list.forEach( p -> {
				
				System.out.println("Problem Id : " + p.getPid());
				System.out.println("Problem name : " + p.getPname());
				System.out.println("Problem Description : " + p.getPdesc());
				System.out.println("Problem type : " + p.getPtype());
				System.out.println("Solved :" + p.isSolved());
				System.out.println("========================");
				
				
			});
		} catch (ProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
