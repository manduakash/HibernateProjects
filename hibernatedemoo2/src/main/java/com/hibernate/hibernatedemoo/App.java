package com.hibernate.hibernatedemoo;

import java.util.Scanner;

import com.hibernate.hibernatedemoo.DaoImpl.StudentDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
       StudentDaoImpl dao = new StudentDaoImpl();
       char c;
       do{
    	   Scanner sc = new Scanner(System.in);
    	   System.out.println("PRESS 1 for add student \n PRESS 2 for display student \n"
    	   		+ "PRESS 3 for update \n PRESS 4 for delete \n PRESS 5 for Exit");
    	   int a = sc.nextInt();
    	   switch(a) {
    	   case 1: dao.addStudent();
    	   break;
    	   case 2: dao.fetchStudent();
    	   break;
    	   case 3: dao.updateStudent();
    	   break;
    	   case 4: dao.deleteStudent();
    	   break;
    	   case 5: System.exit(0);
    	   break;
    	   default: System.out.println("Invalid Choice!");
    	   }
    	   System.out.println("Do you want to continue? Y/N");
    	   c = sc.next().charAt(0);
       }while(c == 'y' || c == 'Y');
       System.out.println("Thank You");
    }
}
