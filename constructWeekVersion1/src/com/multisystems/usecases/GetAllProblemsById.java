package com.multisystems.usecases;

import java.util.List;
import java.util.Scanner;

import com.multisystems.bean.Problem;
import com.multisystems.dao.EmployeeDaoImpl;
import com.multisystems.exceptions.ProblemException;

public class GetAllProblemsById {

	
	public static void main(String[] args) {
		
		
		System.out.println("Enter Id no. ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		try {
			List<Problem> list = dao.getProblemsById(n);
			for(Problem l : list) {
				System.out.println(l);
			}
		} catch (ProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
