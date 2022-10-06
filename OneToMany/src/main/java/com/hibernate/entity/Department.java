package com.hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int did;
	@Column(length=15, nullable=false)
	private String dname;
	@Column(length=15, nullable=false)
	private String dhead;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="did")
	private List<Employee> employee;
}
