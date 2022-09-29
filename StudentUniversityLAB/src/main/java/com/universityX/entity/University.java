package com.universityX.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class University {
	@Id	// primary key
	@GeneratedValue(strategy = GenerationType.AUTO)	//auto increament id
	private int uid;
	@Column(name="university_name", length=20, nullable=false)
	private String uname;
	@Column(name="university_location", length=10, nullable=false)
	private String ulocation;
	@Column(name="university_mail", length=30, nullable=false)
	private String umail;
	
	@OneToMany(cascade = CascadeType.ALL)	// table joining relation type
	@JoinColumn(name="uid")					// join by uid column
	private List<Student> student;			//has a relation 
}
