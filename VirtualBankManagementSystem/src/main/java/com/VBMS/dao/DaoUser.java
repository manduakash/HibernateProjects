package com.VBMS.dao;

import com.VBMS.entity.BankUser;

//Dao interface for CRUD operations of user
public interface DaoUser {

	// for creating new user account
	void createAccount(BankUser user);
	
	// for fetching user account details
	BankUser balanceInquiry(int accountNo, int pin);
	
	// for updating user account details
	BankUser deposite(int accountNo , int pin, BankUser user);
	
	// for updating user account details
	BankUser withdrawal(int accountNo, int pin, BankUser user);

	// for updating user account details
	BankUser changePin(int accountNo, int pin, BankUser user);

	// for deleting existing user account
	void deleteAccount(int accountNo, int pin);
}
