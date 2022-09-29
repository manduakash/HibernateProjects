package com.universityX.main;

import com.universityX.dao.UniversityDao;
import com.universityX.daoimpl.UniversityDaoImpl;


public class App 
{
    public static void main( String[] args )
    {	//instantiating dao object to invoke CRUD operations from Dao
    	UniversityDao dao = new UniversityDaoImpl();
    	
    	// create operation for university
        dao.addUniversity();
        // reading datas from DB 
        dao.fetchUniversity();
    }
}
