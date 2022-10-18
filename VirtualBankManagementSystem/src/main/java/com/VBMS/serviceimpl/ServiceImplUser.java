package com.VBMS.serviceimpl;

import com.VBMS.dao.DaoUser;
import com.VBMS.daoimpl.DaoImplUser;
import com.VBMS.entity.BankUser;
import com.VBMS.service.ServiceUser;

//using service layer for loose coupling purpose
public class ServiceImplUser implements ServiceUser{
	
	//instantiating polymorphic dao object
	DaoUser daoUser = new DaoImplUser();
	
	@Override
	public void createAccount(BankUser user) {
		// TODO Auto-generated method stub
		daoUser.createAccount(user);
	}

	@Override
	public BankUser balanceInquiry(int accountNo, int pin) {
		// TODO Auto-generated method stub
		BankUser returnUser = daoUser.balanceInquiry(accountNo, pin);
		return returnUser;
	}

	@Override
	public BankUser deposite(int accountNo, int pin, BankUser user) {
		// TODO Auto-generated method stub
		BankUser returnUser = daoUser.deposite(accountNo, pin, user);
		return returnUser;
	}

	@Override
	public BankUser withdrawal(int accountNo, int pin, BankUser user) {
		// TODO Auto-generated method stub
		BankUser returnUser = daoUser.withdrawal(accountNo, pin, user);
		return returnUser;
	}

	@Override
	public BankUser changePin(int accountNo, int pin, BankUser user) {
		// TODO Auto-generated method stub
		BankUser returnUser = daoUser.changePin(accountNo, pin, user);
		return returnUser;
	}

	@Override
	public void deleteAccount(int accountNo, int pin) {
		// TODO Auto-generated method stub
		daoUser.deleteAccount(accountNo, pin);
	}

}
