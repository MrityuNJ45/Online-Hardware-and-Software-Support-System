package com.multisystems.usecases;

import java.util.Scanner;

import com.multisystems.dao.EmployeeDaoImpl;
import com.multisystems.exceptions.ProblemException;

public class GetProblemStatusUsecase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Problem Id : ");
		int n = sc.nextInt();
		
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		try {
			String s = dao.getProblemStatus(n);
			System.out.println("Your problem is assigned to " + s);
		} catch (ProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
