package com.multisystems.usecases;

import java.util.Scanner;

import com.multisystems.dao.EngineerDaoImpl;
import com.multisystems.exceptions.ProblemException;

public class UpdateSolvedStatusUsecase {

	public static void main(String[] args) {
		
		System.out.println("Enter Problem ID : ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		EngineerDaoImpl dao = new EngineerDaoImpl();
		try {
			String s = dao.updateSolveStatus(i);
			System.out.println(s);
		} catch (ProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
