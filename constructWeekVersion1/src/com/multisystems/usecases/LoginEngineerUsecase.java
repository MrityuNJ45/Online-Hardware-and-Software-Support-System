package com.multisystems.usecases;

import java.util.Scanner;

import com.multisystems.dao.EngineerDaoImpl;
import com.multisystems.exceptions.EngineerException;

public class LoginEngineerUsecase {

	public static void main(String[] args) {
		
		System.out.println("Enter Username : ");
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		System.out.println("Enter Password : ");
		String pass = sc.next();
		
		EngineerDaoImpl dao = new EngineerDaoImpl();
		try {
			String s = dao.loginEngineer(username, pass);
			System.out.println(s);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
