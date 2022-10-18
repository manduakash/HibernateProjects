package com.VBMS.serviceimpl;

import java.util.List;
import java.util.Optional;

import com.VBMS.dao.DaoEmp;
import com.VBMS.daoimpl.DaoImplEmp;
import com.VBMS.entity.BankEmployee;
import com.VBMS.entity.BankUser;
import com.VBMS.exception.GlobalException;
import com.VBMS.service.ServiceEmp;


//using service layer for loose coupling purpose
public class ServiceImplEmp implements ServiceEmp{
	
	//instantiating polymorphic dao object
	DaoEmp daoEmp = new DaoImplEmp();
	
	@Override
	public void createEmp(BankEmployee emp) {
		// TODO Auto-generated method stub
		daoEmp.createEmp(emp);
		
	}

	@Override
	public List<BankUser> fetchAllUsers(String username, String password) throws GlobalException {
		// TODO Auto-generated method stub
		List<BankUser> users = daoEmp.fetchAllUsers(username, password);
		//null validation
		return Optional.of(users).orElseThrow(() -> new GlobalException("User does not exists"));
	}

	@Override
	public BankEmployee changePassword(String username, String password, BankEmployee emp) {
		// TODO Auto-generated method stub
		BankEmployee returnEmp = daoEmp.changePassword(username, password, emp);
		return returnEmp;
	}

	@Override
	public void deactivateAccount(String username, String password) {
		// TODO Auto-generated method stub
		daoEmp.deactivateAccount(username, password);
	}

}
