package com.multisystems.dao;

import java.util.List;

import com.multisystems.bean.Employee;
import com.multisystems.bean.Problem;
import com.multisystems.exceptions.EmployeeException;
import com.multisystems.exceptions.EngineerException;
import com.multisystems.exceptions.ProblemException;

public interface EmployeeDao {

	public String registerEmployee(Employee e) throws EmployeeException;
	
	public int registerComplain(Problem p) throws ProblemException;
	
	public String getProblemStatus(int id) throws ProblemException;
	
	public List<Problem> getProblemsById(int id) throws ProblemException;
	
}
