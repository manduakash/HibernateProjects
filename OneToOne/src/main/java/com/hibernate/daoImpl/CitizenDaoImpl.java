package com.hibernate.daoImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.config.HibernateUtil;
import com.hibernate.dao.CitizenDao;
import com.hibernate.entity.Address;
import com.hibernate.entity.Citizen;

public class CitizenDaoImpl implements CitizenDao{
	//creating instance objects so we can excess globally 
	Session session = HibernateUtil.activateSession();
	Transaction t = session.beginTransaction();
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void addCitizen() {
		
		
		//adding citizen properties
		Citizen c = new Citizen();
		c.setCname("Akash");
		c.setSurname("Singh");
		c.setPhone(620273472);
		c.setEmail("manduakash");
		c.setDob("2000-05-28");
		
		//adding address properties
		Address a = new Address();
		a.setId(12345);
		a.setIdType("aadhar");
		a.setAddress("xyz house");
		a.setCity("bihar");
		a.setState("purnea");
		a.setPincode(854301);
		
		//setting aggragation property to Citizen object
		c.setAddress(a);
		
		session.save(c);
		System.out.println("adding done");
		t.commit();
	}

	@Override
	public void fetchCitizen() {
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("from Citizen");
		
		// list with Citizen entity
		@SuppressWarnings("unchecked")
		List<Citizen> al = q.getResultList();
		
		//traverse 
		Iterator<Citizen> itr = al.iterator();
		while(itr.hasNext()) {
			Citizen c1 = itr.next();
			Address a1 = c1.getAddress();
		
		//output
		System.out.println("Customer details:"+c1.getCid()+" "+c1.getCname()+" "+c1.getSurname()+" "+c1.getPhone()+" "+c1.getEmail()+" "+c1.getDob());
		System.out.println("Address details:"+a1.getId()+" "+a1.getIdType()+" "+a1.getCity()+" "+a1.getState()+" "+a1.getAddress());
		}
	}
	
}
