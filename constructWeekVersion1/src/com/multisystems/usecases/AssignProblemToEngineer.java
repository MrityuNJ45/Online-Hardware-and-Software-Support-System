package com.multisystems.usecases;

import java.util.Scanner;

import com.multisystems.dao.HodDaoImpl;
import com.multisystems.exceptions.ProblemException;

public class AssignProblemToEngineer {

	public static void main(String[] args) {
		
		System.out.println("Enter Problem Id : ");
		Scanner sc = new Scanner(System.in);
		int pid = sc.nextInt();
		System.out.println("Enter Engineer Id : ");
		int eid = sc.nextInt();
		
		HodDaoImpl dao = new HodDaoImpl();
		try {
			String s = dao.assignProblemToEng(eid, pid);
			System.out.println(s);
		} catch (ProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
