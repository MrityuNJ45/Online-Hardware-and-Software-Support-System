package com.multisystems.dao;

import com.multisystems.bean.Employee;
import com.multisystems.exceptions.EmployeeException;

public interface EmployeeDao {

	public String registerEmployee(Employee e) throws EmployeeException;
	
}
