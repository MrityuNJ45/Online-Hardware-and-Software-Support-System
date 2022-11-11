package com.multisystems.dao;

import java.util.List;

import com.multisystems.bean.Problem;
import com.multisystems.exceptions.ProblemException;

public interface EngineerDao {

	public List<Problem> getProblemByEngineer(String uname) throws ProblemException;
	
	public String updateSolveStatus(int pid) throws ProblemException;
	
	
}
