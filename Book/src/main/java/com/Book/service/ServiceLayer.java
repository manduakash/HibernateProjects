package com.Book.service;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.Book.dao.Dao;
import com.Book.daoImpl.DAOimpl;
import com.Book.entity.Book;



public class ServiceLayer {
	Dao dao = new DAOimpl();										//polymoriphic DAO obj.
	
	//----------------------------------------------------------------------------------------------------------------
		public void addBook(){										//for create operation
			Book b = new Book();									//Entity obj.
			Scanner scan = new Scanner(System.in);					//Scanner obj.
			
			//taking user input
			int bookID = Integer.parseInt(JOptionPane.showInputDialog("Enter book id:"));
			String title = JOptionPane.showInputDialog("Enter title:");
			String author = JOptionPane.showInputDialog("Enter author:");
			int price = Integer.parseInt(JOptionPane.showInputDialog("Enter price:"));
			
			//setting all employee details within employee entity
			b.setBook_ID(bookID);
			b.setTitle(title);
			b.setAuthor(author);
			b.setPrice(price);
			
			dao.add(b); 											//calling add method from DAO interface
			System.out.println("Employee successfully added...");
			scan.close(); 												//closing scanner obj.
		}
	//----------------------------------------------------------------------------------------------------------------
		public void fetchBook(){										//for read operation
			Scanner scan = new Scanner(System.in);						//Scanner obj.
			
			//taking user input
			int book_ID = Integer.parseInt(JOptionPane.showInputDialog("Enter book id:"));
			dao.fetch(book_ID); 										//callin fetch displayEmployee method from Dao interface
			
			scan.close(); 												//closing scanner obj.
		}
	//----------------------------------------------------------------------------------------------------------------

}
