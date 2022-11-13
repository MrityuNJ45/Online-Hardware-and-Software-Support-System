package com.multisystems.dao;

import java.util.List;

import com.multisystems.bean.Problem;
import com.multisystems.exceptions.EngineerException;
import com.multisystems.exceptions.ProblemException;

public interface EngineerDao {

	public List<Problem> getProblemByEngineer(String uname) throws ProblemException;
	
	public String updateSolveStatus(int pid) throws ProblemException;
	
	public String loginEngineer(String username, String password) throws EngineerException;
	
	public String changePassword(int i, String newPass) throws EngineerException;
	
}
