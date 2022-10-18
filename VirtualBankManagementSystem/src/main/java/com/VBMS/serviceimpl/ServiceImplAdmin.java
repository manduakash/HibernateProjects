package com.VBMS.serviceimpl;

import java.util.List;
import java.util.Optional;

import com.VBMS.dao.DaoAdmin;
import com.VBMS.daoimpl.DaoImplAdmin;
import com.VBMS.entity.BankAdmin;
import com.VBMS.entity.BankEmployee;
import com.VBMS.entity.BankUser;
import com.VBMS.exception.GlobalException;
import com.VBMS.service.ServiceAdmin;

//using service layer for loose coupling purpose
public class ServiceImplAdmin implements ServiceAdmin{

	//instantiating polymorphic dao object
	DaoAdmin daoAdmin = new DaoImplAdmin();
	
	@Override
	public void createAdmin(BankAdmin admin) {
		// TODO Auto-generated method stub
		daoAdmin.createAdmin(admin);
	}

	@Override
	public List<BankUser> fetchAllUsers(String username, String password) throws GlobalException{
		// TODO Auto-generated method stub
		List<BankUser> users = daoAdmin.fetchAllUsers(username, password);
		//null validation
		return Optional.of(users).orElseThrow(() -> new GlobalException("User does not exists"));
	}

	@Override
	public List<BankEmployee> fetchAllEmployees(String username, String password) throws GlobalException{
		// TODO Auto-generated method stub
		List<BankEmployee> emps = daoAdmin.fetchAllEmployees(username, password);
		//null validation
		return Optional.of(emps).orElseThrow(() -> new GlobalException("Employee does not exists"));
	}

	@Override
	public BankAdmin changePassword(String username, String password, BankAdmin admin) {
		// TODO Auto-generated method stub
		BankAdmin returnAdmin = daoAdmin.changePassword(username, password, admin);
		return returnAdmin;
	}

	@Override
	public void deactivateAccount(String username, String password) {
		// TODO Auto-generated method stub
		daoAdmin.deactivateAccount(username, password);
	}

	@Override
	public void deleteUser(String username, String password, int accountNo) {
		// TODO Auto-generated method stub
		daoAdmin.deleteUser(username, password, accountNo);
	}

	@Override
	public void deleteEmployee(String adminUsername, String adminPassword, String empUsername) {
		// TODO Auto-generated method stub
		daoAdmin.deleteEmployee(adminUsername, adminPassword, empUsername);
	}

}
