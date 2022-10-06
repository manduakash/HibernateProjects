package com.vehicle.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//creating session method within the HibernateUtil class
public class HibernateUtil {	//util class
	
	public static Session activateSession() {	//creating and returning session method
		Configuration config = new Configuration().configure();	
		SessionFactory sFactory = config.buildSessionFactory();
		Session session = sFactory.openSession();
	
		return session;		//returning the session
	}
}