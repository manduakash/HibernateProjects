package com.hibernateEmployee.main;

import javax.swing.JOptionPane;

import com.hibernateEmployee.service.ServiceLayer;

public class App 
{
    public static void main( String[] args )
    {
  
        do{
           ServiceLayer service = new ServiceLayer();	//calling dao functions using Service Layer
     	   
     	   int a = Integer.parseInt(JOptionPane.showInputDialog("PRESS 1: for adding employee \nPRESS 2: for displaying employee \n"
     	   		+"PRESS 3: for update employee \nPRESS 4: for delete employee\nPRESS 5: for Exit"));
     	   switch(a){
     	   case 1: service.createEmp();
     	   break;
     	   case 2: service.readEmp();
     	   break;
     	   case 3: service.updateEmp();
     	   break;
     	   case 4: service.deleteEmp();
     	   break;
     	   case 5: System.exit(0);
     	   default: System.out.println("Invalid Choice!");
     	   }
        }while(true);
     }
}
