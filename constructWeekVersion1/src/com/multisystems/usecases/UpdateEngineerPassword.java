package com.multisystems.usecases;

import java.util.Scanner;

import com.multisystems.dao.EngineerDaoImpl;
import com.multisystems.exceptions.EngineerException;

public class UpdateEngineerPassword {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Engineer ID : ");
		int i = sc.nextInt();
		System.out.println("Enter new Password : ");
		String s = sc.next();
		
		EngineerDaoImpl dao = new EngineerDaoImpl();
		try {
			String a = dao.changePassword(i, s);
			System.out.println(a);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
