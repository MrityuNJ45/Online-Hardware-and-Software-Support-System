package com.multisystems.usecases;

import java.util.Scanner;

import com.multisystems.dao.HodDaoImpl;
import com.multisystems.exceptions.EngineerException;

public class DeleteEngineerById {

	public static void main(String[] args) {
		
		System.out.println("Enter Id of the Employee to delete : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HodDaoImpl dao = new HodDaoImpl();
		try {
			String s = dao.deleteEngineerById(n);
			System.out.println(s);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
