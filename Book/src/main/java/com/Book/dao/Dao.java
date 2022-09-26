package com.Book.dao;

import com.Book.entity.Book;

public interface Dao {	//data access obj. class 
		
		// declaring CRUD operations
		
		// for adding employee entity
		void add(Book b);				//create
		
		// for fetching data of employee entity
		void fetch(int book_ID);				//read
}
