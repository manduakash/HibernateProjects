package com.universityX.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
	@Id	// primary key
	private int sid;
	@Column(name="student_name", length=20, nullable=false)
	private String sname;
	@Column(name="student_department", length=10, nullable=false)
	private String department;
	@Column(name="student_contact", length=10, nullable=false)
	private long contactNo;
	@Column(name="student_email", length=20, nullable=false)
	private String smail;
	@Column(name="student_address", length=20, nullable=false)
	private String address;
	
	
	
}
