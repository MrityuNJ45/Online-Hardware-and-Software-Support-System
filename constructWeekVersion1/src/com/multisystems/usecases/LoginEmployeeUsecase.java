package com.multisystems.usecases;

import java.util.Scanner;

import com.multisystems.dao.EmployeeDaoImpl;
import com.multisystems.exceptions.EmployeeException;

public class LoginEmployeeUsecase {

	public static void main(String[] args) {
		
		System.out.println("Enter username : ");
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		System.out.println("Enter Password : ");
		String pass = sc.next();
		String s = null;
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		try {
			s = dao.loginEmployee(username, pass);
			System.out.println(s);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
}
