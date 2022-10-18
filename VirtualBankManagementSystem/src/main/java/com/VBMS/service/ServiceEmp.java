package com.VBMS.service;

import java.util.List;

import com.VBMS.entity.BankEmployee;
import com.VBMS.entity.BankUser;
import com.VBMS.exception.GlobalException;

public interface ServiceEmp {
	// for creating new Employee account
	void createEmp(BankEmployee emp);
	
	// for fetching admin account details
	List<BankUser> fetchAllUsers(String username, String password) throws GlobalException;
	
	// for updating Employee account details
	BankEmployee changePassword(String username, String password, BankEmployee emp);
	
	// for deleting existing Employee account
	void deactivateAccount(String username, String password);
}
