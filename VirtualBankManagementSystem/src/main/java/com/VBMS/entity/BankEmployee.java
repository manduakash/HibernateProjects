package com.VBMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Bank_Emp_Details")
@NoArgsConstructor
@AllArgsConstructor
public class BankEmployee {
	
	//bank employee properties
	@Id
	@Column(name="Emp_username", length=15, nullable=false, unique=true)
	private String username;	
	
	@Column(name="first_name", length=10, nullable=false)
	private String fname;
	
	@Column(name="last_name", length=10, nullable=false)
	private String lname;
	
	@Column(name="Emp_password", length=15, nullable=false)
	private String password;
	
}
