package com.multisystems.usecases;

import java.util.Scanner;

import com.multisystems.bean.Engineer;
import com.multisystems.dao.HodDaoImpl;

public class RegisterEngineerUsecase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Engineer id : ");
		int n = sc.nextInt();
		System.out.println("Enter Engineer name : ");
		String name = sc.next();
		System.out.println("Choose Dept : ");
		System.out.println(" 1. Software");
		System.out.println(" 2. Hardware");
		int i = sc.nextInt();
		String dept ;
		if( i == 1 ) {
			dept = "Software";
		}else {
			dept = "Hardware";
		}
		System.out.println("Enter Username : ");
		String username = sc.next();
		
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		Engineer e = new Engineer(n,name,dept,username,password);
		
		HodDaoImpl dao = new HodDaoImpl();
		String s = dao.registerNewEngineer(e);
		System.out.println(s);
		
	}
	
	
}
