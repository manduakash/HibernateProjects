package com.hibernateEmployee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity							
@Table(name="employee_table")	
public class employee {
	
	//pojo data members with persistance table annotations
	@Id	//primary key
	@GeneratedValue(strategy=GenerationType.AUTO)	//auto-increment 
	@Column(name="e_ID")
	private int e_ID;
	
	@Column(name="e_Name" ,length=20, nullable=false)
	private String name;
	
	@Column(name="dept" ,length=10, nullable=false)
	private String dept;
	
	@Column(name="location" ,length=10, nullable=false)
	private String location;
	
	@Column(name="contact" ,length=10, nullable=false, unique=true)
	private long contact;
	
	@Column(name="email" ,length=20, nullable=false, unique=true)
	private String email;
	

	//getters and setters
	public int getE_ID() {
		return e_ID;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public String getLocation() {
		return location;
	}

	public long getContact() {
		return contact;
	}

	public void setE_ID(int e_ID) {
		this.e_ID = e_ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "employee [e_ID=" + e_ID + ", name=" + name + ", dept=" + dept + ", location=" + location + ", contact="
				+ contact + ", email=" + email + "]";
	}

	
	
	
}
