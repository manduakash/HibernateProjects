package com.Book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity							
@Table(name="Book_details")	
public class Book {
	
	//pojo data members with persistance table annotations
	@Id	//primary key
	@Column(name="book_ID")
	private int book_ID;
	
	@Column(name="title" ,length=20, nullable=false)
	private String title;
	
	@Column(name="author" ,length=20, nullable=false)
	private String author;
	
	@Column(name="price" ,length=5, nullable=false, unique=true)
	private double price;

	//getters and setters
	public int getBook_ID() {
		return book_ID;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public void setBook_ID(int book_ID) {
		this.book_ID = book_ID;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	

	
	
	
}
