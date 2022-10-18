package com.VBMS.dao;

import java.util.List;

import com.VBMS.entity.BankEmployee;
import com.VBMS.entity.BankUser;

//Dao interface for CRUD operations of Employee
public interface DaoEmp {
	
	// for creating new Employee account
	void createEmp(BankEmployee emp);
	
	// for fetching admin account details
	List<BankUser> fetchAllUsers(String username, String password);
	
	// for updating Employee account details
	BankEmployee changePassword(String username, String password,BankEmployee emp);
	
	// for deleting existing Employee account
	void deactivateAccount(String username, String password);
}
