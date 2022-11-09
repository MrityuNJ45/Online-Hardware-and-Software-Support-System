package com.multisystems.dao;

import java.util.List;

import com.multisystems.bean.Engineer;
import com.multisystems.bean.Problem;
import com.multisystems.exceptions.EngineerException;
import com.multisystems.exceptions.ProblemException;

public interface HodDao {

	public String registerNewEngineer(Engineer e);
	
	public List<Engineer> getAllEngineers() throws EngineerException;
	
	public String deleteEngineerById(int n) throws EngineerException;
	
	public List<Problem> getAllProblems() throws ProblemException;
	
}
