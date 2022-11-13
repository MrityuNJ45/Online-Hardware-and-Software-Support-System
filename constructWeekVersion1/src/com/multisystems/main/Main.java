package com.multisystems.main;

import java.util.List;
import java.util.Scanner;

import com.multisystems.bean.Problem;
import com.multisystems.dao.EmployeeDaoImpl;
import com.multisystems.dao.EngineerDaoImpl;
import com.multisystems.exceptions.EmployeeException;
import com.multisystems.exceptions.EngineerException;
import com.multisystems.exceptions.ProblemException;
import com.multisystems.usecases.AssignProblemToEngineer;
import com.multisystems.usecases.DeleteEngineerById;
import com.multisystems.usecases.GetAllEngineersUsecase;
import com.multisystems.usecases.GetAllProblems;
import com.multisystems.usecases.GetAllProblemsById;
import com.multisystems.usecases.GetProblemStatusUsecase;
import com.multisystems.usecases.RegisterComplainUsecase;
import com.multisystems.usecases.RegisterEngineerUsecase;
import com.multisystems.usecases.UpdateEngineerPassword;
import com.multisystems.usecases.UpdateSolvedStatusUsecase;

public class Main {

	public static void main(String[] args) {

		System.out.println("****************************");
		System.out.println("Use as : ");
		System.out.println("1. HOD");
		System.out.println("2. Engineer");
		System.out.println("3. Employee");
		System.out.println("****************************");

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 1) {

			System.out.println("1. Login");
			int x = sc.nextInt();
			if (x == 1) {

				System.out.println("Enter username : ");
				String uname = sc.next();
				System.out.println("Enter Password : ");
				String pass = sc.next();
				if (uname.equals("hello") && pass.equals("1234")) {

					System.out.println("*******************************");
					System.out.println("Select options : ");
					System.out.println("1. Register New Engineer.");
					System.out.println("2. Delete Engineer Data.");
					System.out.println("3. Get All Engineers Data.");
					System.out.println("4. Get All Problems.");
					System.out.println("5. Assign Problem to Engineer.");
					System.out.println("*******************************");

					int a = sc.nextInt();
					if (a == 1) {
						RegisterEngineerUsecase.main(args);
					} else if (a == 2) {
						DeleteEngineerById.main(args);
					} else if (a == 3) {
						GetAllEngineersUsecase.main(args);
					} else if (a == 4) {
						GetAllProblems.main(args);
					}else if(a == 5) {
						AssignProblemToEngineer.main(args);
					}

				}

			} else {
				System.out.println("Wrong Credentials...");
			}

		} else if (n == 2) {

			// Engineer Zone

			System.out.println("Enter Username : ");

			String username = sc.next();
			System.out.println("Enter Password : ");
			String pass = sc.next();

			String s = null;
			EngineerDaoImpl dao = new EngineerDaoImpl();
			try {
				s = dao.loginEngineer(username, pass);
				System.out.println(s);
			} catch (EngineerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (s.equals("Login Successfully..")) {

				System.out.println("Enter The Correct Option : ");
				System.out.println("1. To view all Problems assigned to me");

				System.out.println("2. Update Solve Status.");
				System.out.println("3. To change Password.");

				int k = sc.nextInt();
				if (k == 1) {

					EngineerDaoImpl dao1 = new EngineerDaoImpl();
					try {
						List<Problem> list = dao1.getProblemByEngineer(username);
						list.forEach(p -> {

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

				} else if (k == 2) {

					UpdateSolvedStatusUsecase.main(args);

				} else if (k == 3) {

					UpdateEngineerPassword.main(args);
					
				} else {
                     System.out.println("Please Enter Valid Option. ");
				}

			}

		} else if (n == 3) {

			// Employee Zone
			System.out.println("Enter Username : ");

			String username = sc.next();
			System.out.println("Enter Password : ");
			String pass = sc.next();

			String s1 = null;

			EmployeeDaoImpl dao2 = new EmployeeDaoImpl();

			try {
				s1 = dao2.loginEmployee(username, pass);
				System.out.println(s1);
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (s1.equals("Login Successfully..")) {

				System.out.println("1. Register Complain");
				System.out.println("2. To see problem status");
				System.out.println("3. To see all the problems raised by you.");
				System.out.println("4. To change password.");
				int a = sc.nextInt();
				if (a == 1) {

					RegisterComplainUsecase.main(args);

				} else if (a == 2) {

					GetProblemStatusUsecase.main(args);

				} else if (a == 3) {
					GetAllProblemsById.main(args);
				} else if (a == 4) {
					System.out.println("Enter Your Employee ID : ");
					int k = sc.nextInt();
					System.out.println("Enter Your New Password : ");
					String npass = sc.next();

					EmployeeDaoImpl dao = new EmployeeDaoImpl();
					String s = null;

					try {
						s = dao.updatePassword(k, npass);
					} catch (EmployeeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println(s);

				}
			}

		} else {
			System.out.println("Please select a valid input..");
		}

	}

}
