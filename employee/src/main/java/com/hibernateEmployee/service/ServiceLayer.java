package com.hibernateEmployee.service;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.hibernateEmployee.dao.DAO;
import com.hibernateEmployee.dao.DAOimpl;
import com.hibernateEmployee.entity.employee;

public class ServiceLayer {
	DAO dao = new DAOimpl();									//polymoriphic DAO obj.
	
//----------------------------------------------------------------------------------------------------------------
	public void createEmp(){									//for create operation
		employee emp = new employee();							//Entity obj.
		Scanner scan = new Scanner(System.in);					//Scanner obj.
		
		//taking user input
		String name = JOptionPane.showInputDialog("Enter employee name:");
		String dept = JOptionPane.showInputDialog("Enter employee deptartment:");
		String location = JOptionPane.showInputDialog("Enter employee location:");
		long contact = Long.parseLong(JOptionPane.showInputDialog("Enter employee contact:"));
		
		
		//setting all employee details within employee entity
		emp.setName(name);
		emp.setDept(dept);
		emp.setLocation(location);
		emp.setContact(contact);
		
		dao.addEmployee(emp); 									//calling addEmployee method from DAO interface
		System.out.println("Employee successfully added...");
		scan.close(); 											//closing scanner obj.
	}
//----------------------------------------------------------------------------------------------------------------
	public void readEmp(){										//for read operation
		Scanner scan = new Scanner(System.in);					//Scanner obj.
		
		//taking user input
		int e_ID = Integer.parseInt(JOptionPane.showInputDialog("Enter employee id:"));
		dao.displayEmployee(e_ID); 								//calling displayEmployee method from DAO interface
		
		scan.close(); 											//closing scanner obj.
	}
//----------------------------------------------------------------------------------------------------------------
	public void updateEmp(){									//for update operation
		employee emp = new employee();							//Entity obj.
		Scanner scan = new Scanner(System.in);					//Scanner obj.
		
		//taking user input
		int e_ID = Integer.parseInt(JOptionPane.showInputDialog("Enter employee id:"));
		String name = JOptionPane.showInputDialog("Enter employee name:");
		String dept = JOptionPane.showInputDialog("Enter employee deptartment:");
		String location = JOptionPane.showInputDialog("Enter employee location:");
		long contact = Long.parseLong(JOptionPane.showInputDialog("Enter employee contact:"));
		
		//setting all employee details within employee entity
		emp.setName(name);
		emp.setDept(dept);
		emp.setLocation(location);
		emp.setContact(contact);
		
		dao.updateEmployee(e_ID, emp); 							//calling updateEmployee method from DAO interface
		System.out.println("Employee details updated successfully...");
		scan.close(); 											//closing scanner obj.
	}
//----------------------------------------------------------------------------------------------------------------
	public void deleteEmp(){									//for delete operation
		Scanner scan = new Scanner(System.in);					//Scanner obj.
		
		//taking user input
		int e_ID = Integer.parseInt(JOptionPane.showInputDialog("Enter employee id:"));
	
		dao.deleteEmployee(e_ID); 								//calling deleteEmployee method from DAO interface
		System.out.println("Employee deleted successfully...");
		scan.close(); 											//closing scanner obj.
	}
}
