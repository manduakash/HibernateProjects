package com.hibernateEmployee.dao;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernateEmployee.config.HibernateUtil;
import com.hibernateEmployee.entity.employee;

// concrete class of DAO:- implementation of CRUD operations; 
public class DAOimpl implements DAO{
	// implementing CRUD methods
	
	@Override
	public void addEmployee(employee emp) {
		// Logic for adding employee
		try {
			Session session = HibernateUtil.activateSession();	 //getting session connection established
			Transaction tr = session.beginTransaction();		 //starting transaction 
			session.save(emp);									 //saving obj. datas to DB
			tr.commit();										 //saving changes to DB permanently  
			session.close();								 	 //closing the session
		}
		// dealing with SQL Exceptions
		catch(HibernateException he) {
			System.out.println(he);
		}
		// dealing with General Exceptions
		catch(Exception e) {
			System.out.println(e);
		}		
	}
//----------------------------------------------------------------------------------------------------------------

	@Override
	public void displayEmployee(int e_ID) {
		// Logic for fetching employee details
		try {
			Session session = HibernateUtil.activateSession();					//getting session connection established
			employee empFetch = session.get(employee.class, e_ID);				//getting obj. datas from DB
			//displaying output
			JOptionPane.showMessageDialog(null," employee ID: '"+empFetch.getE_ID()+"' "			
											  +" employee name: '"+empFetch.getName()+"' "
											  +" employee dept: '"+empFetch.getDept()+"' "
											  +" employee contact: '"+empFetch.getContact()+"' "
											  +" employee Location: '"+empFetch.getLocation()+"' ");
			
			session.close();													//closing the session
		}
		// dealing with SQL Exceptions
		catch(HibernateException he) {
			System.out.println(he);
		}
		// dealing with General Exceptions
		catch(Exception e) {
			System.out.println(e);
		}		
	}
//----------------------------------------------------------------------------------------------------------------

	@Override
	public void updateEmployee(int e_ID, employee emp) {
		// Logic for updating employee details
		try {
			Session session = HibernateUtil.activateSession();		//getting session connection established
			Transaction tr = session.beginTransaction();		 	//starting transaction 
			employee empUpdate = session.get(employee.class, e_ID);	//getting obj. datas from DB 
			session.update(empUpdate);								//updating the employee details
			tr.commit();										 	//saving changes to DB permanently  
			session.close();										//closing the session
		}
		// dealing with SQL Exceptions
		catch(HibernateException he) {
			System.out.println(he);
		}
		// dealing with General Exceptions
		catch(Exception e) {
			System.out.println(e);
		}	
	}
//----------------------------------------------------------------------------------------------------------------

	@Override
	public void deleteEmployee(int e_ID) {
		// Logic for deleting employee details
		try {
			Session session = HibernateUtil.activateSession();		//getting session connection established
			Transaction tr = session.beginTransaction();		 	//starting transaction 
			employee empUpdate = session.get(employee.class, e_ID);	//getting obj. datas from DB 
			session.delete(empUpdate);								//deleting the employee details
			tr.commit();											//saving changes to DB permanently 
			session.close();										//closing the session
		}
		// dealing with SQL Exceptions
		catch(HibernateException he) {
			System.out.println(he);
		}
		// dealing with General Exceptions
		catch(Exception e) {
			System.out.println(e);
		}
	}	
//----------------------------------------------------------------------------------------------------------------
	
}
