package com.universityX.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.universityX.config.HibernateUtil;
import com.universityX.dao.UniversityDao;
import com.universityX.entity.Student;
import com.universityX.entity.University;

// implementing unimplementing methods from dao interface
public class UniversityDaoImpl implements UniversityDao{
	
	// creating object for using inside multiple methods
	Session session = HibernateUtil.activateSession();
	Transaction t = session.beginTransaction();
	
	// adding logic
	@Override
	public void addUniversity() {
		// instansiating university object and initializing it
		University university = new University();
		university.setUname("makaut");
		university.setUlocation("kolkata");
		university.setUmail("makautuniversity@gmail.com");
		
		// instansiating studen objects and initializing them
		Student s1 = new Student(101,"Akash","cse",7965194652l,"akash@gmail.com","bihar");
		Student s2 = new Student(102,"sayan","cse",9965194652l,"sayan@gmail.com","kolkata");
		Student s3 = new Student(103,"sankha","cse",8965194652l,"sankha@gmail.com","kolkata");
		Student s4 = new Student(104,"owashim","cse",6965194652l,"owashim@gmail.com","kolkata");
		
		List<Student> students = new ArrayList<>();
		//adding into student list
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		//adding student list into university table
		university.setStudent(students);
		
		// saving to DB
		session.save(university);
		// permanently saving into DB
		t.commit();
		System.out.println("university added...");
	}
	
	// fetching logic
	@Override
	public void fetchUniversity() {
		//taking userinput for university id
		int uID = Integer.parseInt(JOptionPane.showInputDialog("enter university id..."));
		//fetching university details by university id
		University university = session.get(University.class, uID);
		//displaying by SOP
		System.out.println(university);
	}
	
	

}
