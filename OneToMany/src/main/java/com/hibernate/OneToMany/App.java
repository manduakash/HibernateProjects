package com.hibernate.OneToMany;

import com.hibernate.dao.DepartmentDao;
import com.hibernate.daoimpl.DepartmentDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DepartmentDao dao = new DepartmentDaoImpl();
        dao.addDepartment();
    }
}
