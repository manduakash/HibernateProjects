package com.VBMS.service;

import java.util.List;

import com.VBMS.entity.BankAdmin;
import com.VBMS.entity.BankEmployee;
import com.VBMS.entity.BankUser;
import com.VBMS.exception.GlobalException;


public interface ServiceAdmin {
	// for creating new admin account
	void createAdmin(BankAdmin admin);
	
	// for fetching all users account details
	List<BankUser> fetchAllUsers(String username, String password) throws GlobalException;
	
	// for fetching all employees account details
	List<BankEmployee> fetchAllEmployees(String username, String password) throws GlobalException;
	
	// for updating admin account details
	BankAdmin changePassword(String username, String password, BankAdmin admin);
	
	// for deleting existing admin account
	void deactivateAccount(String username, String password);
	
	// for deleting existing user account
	void deleteUser(String username, String password, int accountNo);
	
	// for deleting existing employee account
	void deleteEmployee(String adminUsername, String adminPassword, String empUsername);
}
