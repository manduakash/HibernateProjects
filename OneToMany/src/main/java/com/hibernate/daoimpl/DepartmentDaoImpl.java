package com.hibernate.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.config.HibernateUtil;
import com.hibernate.dao.DepartmentDao;
import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;

public class DepartmentDaoImpl implements DepartmentDao{
	
	// creating object for using inside multiple methods
	Session session = HibernateUtil.activateSession();
	Transaction t = session.beginTransaction();
	
	@Override
	public void addDepartment() {
		// TODO Auto-generated method stub
		Department d = new Department();
		List<Employee> empList = new ArrayList<Employee>();
		
		//putting department values
		d.setDname("IT");
		d.setDhead("mamta mam");
		
		//putting employee 1 values
		Employee emp1 = new Employee();
		emp1.setEid(1);
		emp1.setEname("akash");
		emp1.setSalary(9000.00);
		emp1.setContact(946315112);
		emp1.setAddress("lapataganj");
		
		//putting employee 2 values
		Employee emp2 = new Employee();
		emp2.setEid(2);
		emp2.setEname("sayan");
		emp2.setSalary(9000.00);
		emp2.setContact(846315786);
		emp2.setAddress("lapataganj");
				
		//putting employee 3 values
		Employee emp3 = new Employee();
		emp3.setEid(3);
		emp3.setEname("sankha");
		emp3.setSalary(9000.00);
		emp3.setContact(746315573);
		emp3.setAddress("lapataganj");
		
		//adding all employee into emp list.
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		
		session.save(d);
		System.out.println("department adding done successfully...S");
		t.commit();
	}

	@Override
	public void fetchDepartment() {
		// TODO Auto-generated method stub
		
	}

}
