package com.VBMS.Bank;

import java.util.List;

import javax.swing.JOptionPane;

import com.VBMS.entity.BankAdmin;
import com.VBMS.entity.BankEmployee;
import com.VBMS.entity.BankUser;
import com.VBMS.service.ServiceAdmin;
import com.VBMS.service.ServiceEmp;
import com.VBMS.service.ServiceUser;
import com.VBMS.serviceimpl.ServiceImplAdmin;
import com.VBMS.serviceimpl.ServiceImplEmp;
import com.VBMS.serviceimpl.ServiceImplUser;

//crud operations for all entity
public class CrudMenu {
	
	//main menu for all crud operations
	public static void mainMenu() {
		while(true) {
			
			//User Menu list
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("+             ~MAIN-MENU~            +");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("|      Enter 1. -> Admin Menu        |");
			System.out.println("|      Enter 2. -> Employee Menu     |");
			System.out.println("|      Enter 3. -> User Menu         |");
			System.out.println("|      Enter 4. -> Exit              |");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			
			switch(Integer.parseInt(JOptionPane.showInputDialog("Enter your choice..."))) {
				
				case 1: crudAdmin();
				break;
				
				case 2: crudEmp();
				break;
				
				case 3: crudUser();
				break;
				
				case 4: System.exit(0);
				break;
				
				default: 
					System.out.println("Invalid choice!");
					JOptionPane.showMessageDialog(null, "Invalid choice!");
					break;
					
			}//end switch case
		}//end while loop
	}//end mainMenu()
		
	
	// instantiating polymorphic service objects
	static ServiceAdmin serviceAdmin = new ServiceImplAdmin();
	static ServiceEmp serviceEmp = new ServiceImplEmp();
	static ServiceUser serviceUser = new ServiceImplUser();
	
	//crud operations for admin
	public static void crudAdmin() {
		
		while(true) {
			
			//Admin Menu list
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("+            ~ADMIN-MENU~            +");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("|   Enter 1. -> Create Admin A/c     |\n"+
							   "|   Enter 2. -> All Users Detail     |\n"+
							   "|   Enter 3. -> All Employees Detail |\n"+
							   "|   Enter 4. -> Change Password      |\n"+
							   "|   Enter 5. -> Deactivate Account   |\n"+
							   "|   Enter 6. -> Delete User A/c      |\n"+
							   "|   Enter 7. -> Delete Employee A/c  |\n"+
							   "|   Enter 8. -> Go to Main-Menu      |\n"+
							   "|   Enter 9. -> Exit                 |");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			
			switch(Integer.parseInt(JOptionPane.showInputDialog("Enter your choice..."))) {
			case 1: 
				//creating admin object reference
				BankAdmin admin = new BankAdmin();
				//setting all details into admin using user-input
				admin.setFname(JOptionPane.showInputDialog("Enter admin's first name..."));
				admin.setLname(JOptionPane.showInputDialog("Enter admin's last name..."));
				admin.setUsername(JOptionPane.showInputDialog("Enter admin's username name..."));
				admin.setPassword(JOptionPane.showInputDialog("Enter a password (max length 15)"));
				//invoking create method to create account of admin
				serviceAdmin.createAdmin(admin);
				break;
			
			case 2:	//fetchAllUsers()
				try {
				List<BankUser> users = serviceAdmin.fetchAllUsers(JOptionPane.showInputDialog("Enter your username"),
						 										  JOptionPane.showInputDialog("Enter your password"));
				//displaying the users list
				System.out.println("======================================");
				for (BankUser bankUser : users) {
					System.out.println(
							  "A/c number	: "+bankUser.getAccountNo()+
							  "\nA/c holder	: "+bankUser.getAccountHolder()+																			   								
							  "\nA/c Type	: "+bankUser.getAccountType()+										
							  "\nBranch		: "+bankUser.getBranch()+										
							  "\nContact		: "+bankUser.getContact()+										
							  "\nEmail		: "+bankUser.getEmail()										
									   );
					System.out.println("--------------------------------------");
				}
				System.out.println("======================================");
				JOptionPane.showMessageDialog(null, "Fetching Done.");
				
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				break;	
			
			case 3:	//fetchAllEmps()
				try {
				List<BankEmployee> emps = serviceAdmin.fetchAllEmployees(JOptionPane.showInputDialog("Enter your username"),
						 												 JOptionPane.showInputDialog("Enter your password"));
				//displaying the employees list
				System.out.println("======================================");
				for (BankEmployee bankEmp : emps) {
					System.out.println(
							  "First name	: "+bankEmp.getFname()+
							  "\nLast name	: "+bankEmp.getLname()+																			   								
							  "\nUsername	: "+bankEmp.getUsername()																													
									   );
					System.out.println("--------------------------------------");
				}
				System.out.println("======================================");
				JOptionPane.showMessageDialog(null, "Fetching Done.");
				
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				break;	
			
			case 4:	//changePassword()
				BankAdmin cAdmin = new BankAdmin();
				cAdmin.setPassword(JOptionPane.showInputDialog("Enter your new password (max length 15)"));
				//passing user-input into changePassword()
				BankAdmin chngPassAdmin = serviceAdmin.changePassword(JOptionPane.showInputDialog("Enter your username"),
																	  JOptionPane.showInputDialog("Enter your old password"), cAdmin);
				JOptionPane.showMessageDialog(null ,"Admin "+chngPassAdmin.getUsername()+"'s new password is '"+chngPassAdmin.getPassword()+"'");
				break;	
				
			case 5:	//deactivateAccount()
				//passing user-input for deleting admin account
				serviceAdmin.deactivateAccount(JOptionPane.showInputDialog("Enter your username"),
											   JOptionPane.showInputDialog("Enter your password"));
				break;	
				
			case 6:	//deleteUser()
				//passing user-input for deleting user account
				serviceAdmin.deleteUser(JOptionPane.showInputDialog("Enter admin username"),
										JOptionPane.showInputDialog("Enter admin password"),
										Integer.parseInt(JOptionPane.showInputDialog("Enter user account no. to delete"))
										);
				break;	
				
			case 7:	//deleteEmployee()
				//passing user-input for deleting employee account
				serviceAdmin.deleteEmployee(JOptionPane.showInputDialog("Enter admin username"),
											JOptionPane.showInputDialog("Enter admin password"),
											JOptionPane.showInputDialog("Enter employee username to delete")
						);
				break;	
				
			case 8:	//mainMenu()
				mainMenu();
				break;
			
			case 9: //exit()	
				System.exit(0);
				
			default:
				System.out.println("Invalid choice!");
				JOptionPane.showMessageDialog(null, "Invalid choice!");
			}// switch end
		}//while end
	}//crudAdmin end
	
	//crud operations for employee
	public static void crudEmp() {
		while(true) {
			
			//User Menu list
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("+           ~EMPLOYEE-MENU~          +");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("|   Enter 1. -> Create Employee A/c  |\n"+
							   "|   Enter 2. -> All Users Detail     |\n"+
							   "|   Enter 3. -> Change Password      |\n"+
							   "|   Enter 4. -> Delete Account       |\n"+
							   "|   Enter 5. -> Go to Main-Menu      |\n"+
							   "|   Enter 6. -> Exit                 |");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			
			switch(Integer.parseInt(JOptionPane.showInputDialog("Enter your choice..."))) {
			case 1: 
				//creating employee object reference
				BankEmployee emp = new BankEmployee();
				//setting all details into employee using user-input
				emp.setFname(JOptionPane.showInputDialog("Enter employee's first name"));
				emp.setLname(JOptionPane.showInputDialog("Enter employee's last name"));
				emp.setUsername(JOptionPane.showInputDialog("Enter employee's username name"));
				emp.setPassword(JOptionPane.showInputDialog("Enter a password (max length 15)"));
				//invoking create method to create account of employee
				serviceEmp.createEmp(emp);
				break;
			
			case 2:	//fetchAllUsers()
				try {
				List<BankUser> users = serviceEmp.fetchAllUsers(JOptionPane.showInputDialog("Enter Bank employee username"),
						 										JOptionPane.showInputDialog("Enter Bank employee password"));
				//displaying the users list
				System.out.println("======================================");
				for (BankUser bankUser : users) {
					System.out.println(
							  "A/c number	: "+bankUser.getAccountNo()+
							  "\nA/c holder	: "+bankUser.getAccountHolder()+																			   								
							  "\nA/c Type	: "+bankUser.getAccountType()+										
							  "\nBranch		: "+bankUser.getBranch()+										
							  "\nContact		: "+bankUser.getContact()+										
							  "\nEmail		: "+bankUser.getEmail()										
									   );
					System.out.println("--------------------------------------");
				}
				System.out.println("======================================");
				JOptionPane.showMessageDialog(null, "Fetching Done.");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
				break;
				
			case 3:	//changePassword()
				BankEmployee cEmp = new BankEmployee();
				cEmp.setPassword(JOptionPane.showInputDialog("Enter your new password (max length 15)"));
				//passing user-input into changePassword()
				BankEmployee chngPassEmp = serviceEmp.changePassword(JOptionPane.showInputDialog("Enter Bank employee username"),
																	 JOptionPane.showInputDialog("Enter Bank employee password"), cEmp);
				JOptionPane.showMessageDialog(null, "Employee "+chngPassEmp.getUsername()+"'s new password is '"+chngPassEmp.getPassword()+"'");
				break;
				
			case 4:	//deactivateAccount()
				//passing user-input for deleting account
				serviceEmp.deactivateAccount(JOptionPane.showInputDialog("Enter Bank employee username"),
											 JOptionPane.showInputDialog("Enter Bank employee password"));
				break;	
				
			case 5:	//mainMenu()
				mainMenu();
				break;
			
			case 6: //exit()	
				System.exit(0);
				
			default:
				System.out.println("Invalid choice!");
				JOptionPane.showMessageDialog(null, "Invalid choice!");
			}// switch end
		}//while end
	}//crudEmp end
	
	//crud operations for user
	public static void crudUser() {
		
		while(true) {	//for looping
			
			//User Menu list
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("+             ~USER-MENU~            +");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("|   Enter 1. -> Create User Account  |\n"+
							   "|   Enter 2. -> Check Balance        |\n"+
							   "|   Enter 3. -> Deposite             |\n"+
							   "|   Enter 4. -> Withdraw             |\n"+
							   "|   Enter 5. -> Change Pin           |\n"+
							   "|   Enter 6. -> Delete Account       |\n"+
							   "|   Enter 7. -> Go to Main-Menu      |\n"+
							   "|   Enter 8. -> Exit                 |");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			
			switch(Integer.parseInt(JOptionPane.showInputDialog("Enter your choice..."))) {
			
			case 1: //createAccount()
				//creating user object reference
				BankUser newUser = new BankUser();
				//setting all details into user using user-input
				newUser.setAccountNo(Integer.parseInt(JOptionPane.showInputDialog("Enter an account number (max 10 digits)")));
				newUser.setAccountHolder(JOptionPane.showInputDialog("Enter account holder name"));
				newUser.setAccountType(JOptionPane.showInputDialog("Enter account type (current/saving)"));
				newUser.setBranch(JOptionPane.showInputDialog("Enter your bank branch"));
				newUser.setContact(Long.parseLong(JOptionPane.showInputDialog("Enter your contact number (max 10 digits)")));
				newUser.setEmail(JOptionPane.showInputDialog("Enter your email id"));
				newUser.setPin(Integer.parseInt(JOptionPane.showInputDialog("Enter your secret pin (max 4 digits")));
				newUser.setBalance(Double.parseDouble(JOptionPane.showInputDialog("Deposite any ammount to active the account (minimum amount 1000Rs.)")));
				//invoking create method to create account of user
				serviceUser.createAccount(newUser);
				break;
				
			case 2:	//balanceInquiry()
				//passing user-input into balanceInquiry method 
				int bAccountNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your account number"));
				int bPin = Integer.parseInt(JOptionPane.showInputDialog("Enter your 4 digit pin"));
				BankUser fetchUser = serviceUser.balanceInquiry(bAccountNo, bPin);
				JOptionPane.showMessageDialog(null, "Present Balance of Your A/c "+fetchUser.getAccountNo()+" is Rs: "+fetchUser.getBalance());
				break;
				
			case 3:	//deposite()
				//passing user-input into balanceInquiry method 
				int dAccountNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your account number"));
				int dPin = Integer.parseInt(JOptionPane.showInputDialog("Enter your 4 digit pin"));
				BankUser dUser = new BankUser();
				double dAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter your deposite amount"));
				dUser.setBalance(dAmount);
				BankUser depositeUser = serviceUser.deposite(dAccountNo, dPin, dUser);
				JOptionPane.showMessageDialog(null, "Rs: "+dAmount+" has been credited to Your A/c "+depositeUser.getAccountNo()+"\nCurrent Balance is Rs: "+depositeUser.getBalance());
				break;
				
			case 4:	//withdrawal()
				//passing user-input into withdrawal()
				int wAccountNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your account number"));
				int wPin = Integer.parseInt(JOptionPane.showInputDialog("Enter your 4 digit pin"));
				BankUser wUser = new BankUser();
				double wAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter your withdrawal amount"));
				wUser.setBalance(wAmount);
				BankUser withdrawUser = serviceUser.withdrawal(wAccountNo, wPin, wUser);
				JOptionPane.showMessageDialog(null, "Rs: "+wAmount+" has been debited from Your A/c "+withdrawUser.getAccountNo()+"\nCurrent Balance is Rs: "+withdrawUser.getBalance());
				break;
				
			case 5:	//changePin()
				//passing user-input into changePin()
				int cAccountNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your account number"));
				int cPin = Integer.parseInt(JOptionPane.showInputDialog("Enter your 4 digit pin"));
				BankUser cUser = new BankUser();
				cUser.setPin(Integer.parseInt(JOptionPane.showInputDialog("Enter your new pin (max size 4 digits)")));
				BankUser chngPinUser = serviceUser.changePin(cAccountNo, cPin, cUser);
				JOptionPane.showMessageDialog(null,"A/c "+chngPinUser.getAccountNo()+"'s new pin is '"+chngPinUser.getPin()+"'");
				break;
				
			case 6:	//deleteAccount()
				//passing user-input for deleting account
				int dltAccountNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your account number"));
				int dltPin = Integer.parseInt(JOptionPane.showInputDialog("Enter your 4 digit pin"));
				serviceUser.deleteAccount(dltAccountNo, dltPin);
				break;
				
			case 7:	//mainMenu()
				mainMenu();
				break;
			
			case 8: //exit()	
				System.exit(0);
				
			default:
				System.out.println("Invalid choice!");
				JOptionPane.showMessageDialog(null, "Invalid choice!");
				
			}// switch end
		}//while end
	}//crudUser end
	
//============================================================================================================
	
}
