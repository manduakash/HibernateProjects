package com.Book.daoImpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Book.config.HibernateUtil;
import com.Book.dao.Dao;
import com.Book.entity.Book;

// concrete class of DAO:- implementation of CRUD operations; 
public class DAOimpl implements Dao{
	// implementing CRUD methods
	
	public void add(Book b) {
		// Logic for adding employee
		try {
			Session session = HibernateUtil.activateSession();	 //getting session connection established
			Transaction tr = session.beginTransaction();		 //starting transaction 
			session.save(b);									 //saving obj. datas to DB
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

	public void fetch(int book_ID) {
		// Logic for fetching book details
		try {
			Session session = HibernateUtil.activateSession();					//getting session connection established
			Book bookFetch = session.get(Book.class, book_ID);					//getting obj. datas from DB
			//displaying output
			JOptionPane.showMessageDialog(null," Book ID: '"+bookFetch.getBook_ID()+"' "			
											  +" Book Title: '"+bookFetch.getTitle()+"' "
											  +" Book Author: '"+bookFetch.getAuthor()+"' "
											  +" Book Price: '"+bookFetch.getPrice()+"' ");
			
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

}
