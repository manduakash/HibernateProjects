package com.hibernate.onetoone;

import com.hibernate.dao.CitizenDao;
import com.hibernate.daoImpl.CitizenDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CitizenDao dao  = new CitizenDaoImpl();
        //adding citizen to DB
        dao.addCitizen();
        //getting citizen from DB
        dao.fetchCitizen();
    }
}
