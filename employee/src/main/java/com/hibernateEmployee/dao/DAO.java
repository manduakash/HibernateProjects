package com.hibernateEmployee.dao;

import com.hibernateEmployee.entity.employee;

public interface DAO {	//data access obj. class 
	
	// declaring CRUD operations
	
	// for adding employee entity
	void addEmployee(employee e);				//create
	
	// for fetching data of employee entity
	void displayEmployee(int e_ID);				//read
	
	// for updating the values of existing employee entity 
	void updateEmployee(int e_ID, employee e);	//update
	
	// for deleting the existing employee entity 
	void deleteEmployee(int e_ID);				//delete
}
