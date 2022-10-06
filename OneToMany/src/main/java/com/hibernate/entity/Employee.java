package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	@Column(length=20, nullable=false)
	private String ename;
	@Column(length=8, nullable=false)
	private double salary;
	@Column(length=10, nullable=false)
	private long contact;
	@Column(length=25, nullable=false)
	private String Address;
	
	
}
