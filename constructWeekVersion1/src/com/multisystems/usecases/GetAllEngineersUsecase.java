package com.multisystems.usecases;

import java.util.List;

import com.multisystems.bean.Engineer;
import com.multisystems.dao.HodDaoImpl;
import com.multisystems.exceptions.EngineerException;

public class GetAllEngineersUsecase {

	public static void main(String[] args) {
		
		System.out.println("Getting all Registered Engineers..");
		
		HodDaoImpl dao = new HodDaoImpl();
		try {
			List<Engineer> list = dao.getAllEngineers();
			list.forEach(l -> {
			
				System.out.println("Engineer Id : " + l.getEngId());
				System.out.println("Engineer Name : " + l.getEngName());
				System.out.println("Engineer Department :" + l.getEngName());
				System.out.println("username :" + l.getUsername());
				System.out.println("password :" + l.getPassword());
				System.out.println("===========================");
				
			});
			
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
