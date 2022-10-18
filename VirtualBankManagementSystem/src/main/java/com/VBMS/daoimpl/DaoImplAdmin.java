package com.VBMS.daoimpl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.VBMS.config.HibernateUtil;
import com.VBMS.dao.DaoAdmin;
import com.VBMS.entity.BankAdmin;
import com.VBMS.entity.BankEmployee;
import com.VBMS.entity.BankUser;
import com.VBMS.exception.GlobalException;

// implementing DaoAdmin
public class DaoImplAdmin implements DaoAdmin{

//creating session globally so each and every method can have access of this
	Session session = HibernateUtil.getSession();
		
	//fetching all datas from DB and storing into list reference
	private List<BankUser> users = session.createQuery("FROM BankUser", BankUser.class).getResultList();
	private List<BankEmployee> emps = session.createQuery("FROM BankEmployee", BankEmployee.class).getResultList();
	private List<BankAdmin> admins = session.createQuery("FROM BankAdmin", BankAdmin.class).getResultList();
	
//==========================================================================================================================
	
	//method for creating admin account
	@Override
	public void createAdmin(BankAdmin admin) {
		try{	//activating session

			//validation of admin details
			//for admin first name
			if( (admin.getFname().length()>10) || (admin.getFname()==null) ) {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"First name size should be max 10 letters.");
				throw new GlobalException("Invalid first name entry");
			}
			
			//for admin last name
			if( (admin.getLname().length()>10) || (admin.getLname()==null) ) {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Last name size should be max 10 letters.");
				throw new GlobalException("Invalid last name entry");
			}
			
			//for admin username
			else if( (admin.getUsername().length()>15) || (admin.getUsername()==null) || (admins.stream().anyMatch(x->x.getUsername().equals(admin.getUsername()))) ){	
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"username already taken or size is more than 15 characters.");
				throw new GlobalException("Invalid username entry");
			}
			
			//for employee password
			else if( (admin.getPassword().length()>15) || (admin.getPassword()==null) ){	
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Password should be max 15 characters");
				throw new GlobalException("Invalid password entry");
			}
			
			//if all condition satisfies
			else {
			//adding admin to DB
			session.beginTransaction();
			session.save(admin);
			
			//saving to DB
			session.getTransaction().commit();
			JOptionPane.showMessageDialog(null,"Admin account '"+admin.getUsername()+"' has been created successfully.");
			}
			session.clear();
		}catch(HibernateException he) {	//handeling hibernate exception
			JOptionPane.showMessageDialog(null,"HibernateException: "+ he);
		}catch(Exception e) {			//handeling all kind of exception
			JOptionPane.showMessageDialog(null,"Exception: "+ e);
		}//end catch
	}

//==========================================================================================================================
	
	//method for retrieving all users details
	@Override
	public List<BankUser> fetchAllUsers(String username, String password) {
		try{	//activating session
			//fetching admin data to 
			BankAdmin fetchAdmin = (BankAdmin)session.get(BankAdmin.class, username);
			
			//validations
			//for username
			if( !(admins.stream().anyMatch(x->x.getUsername().equals(username)))  ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid Username");
			}
			//for password
			else if( !(fetchAdmin.getPassword().equals(password)) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid Password");
			}
			//null validation
			else if(users==null) {
				//it will throw GlobalException
				throw new GlobalException("No result found.");
			}
			//if all condition satisfies
			else {
				//it will return list of all bank users
				return users;
			}
			
		}catch(HibernateException he) {	//handeling hibernate exception
			JOptionPane.showMessageDialog(null, he);
		}catch(Exception e) {			//handeling all kind of exception
			JOptionPane.showMessageDialog(null, e);
		}//end catch	
		return null;
	}
	
//==========================================================================================================================
	
	//method for retrieving all employee details
	@Override
	public List<BankEmployee> fetchAllEmployees(String username, String password) {
		try{	//activating session
			//fetching admin data to 
			BankAdmin fetchAdmin = (BankAdmin)session.get(BankAdmin.class, username);
			
			//validations
			//for username
			if( !(admins.stream().anyMatch(x->x.getUsername().equals(username)))  ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid username");
			}
			//for password
			else if( !(fetchAdmin.getPassword().equals(password)) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid password");
			}
			//null validation
			else if(emps==null) {
				//it will throw GlobalException
				throw new GlobalException("No result found.");
			}
			//if all condition satisfies
			else {
				//it will return list of all bank users
				return emps;
			}
			
		}catch(HibernateException he) {	//handeling hibernate exception
			JOptionPane.showMessageDialog(null, he);
		}catch(Exception e) {			//handeling all kind of exception
			JOptionPane.showMessageDialog(null, e);
		}//end catch	
		return null;
	}

//==========================================================================================================================
	
	//method for updating admin details	
	@Override
	public BankAdmin changePassword(String username, String password, BankAdmin admin) {
		try{	//activating session
			//fetching admin data
			BankAdmin fetchAdmin = (BankAdmin)session.get(BankAdmin.class, username);
			
			//validations
			//for username
			if( !(admins.stream().anyMatch(x->x.getUsername().equals(username)))  ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid username");
			}
			//for password
			else if( !(fetchAdmin.getPassword().equals(password)) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid password");
			}
			//if all condition satisfies
			else {
				//setting updated values
				fetchAdmin.setPassword(admin.getPassword());
				
				//it will upadate the value first then will return
				session.beginTransaction();			//activating transaction 
				session.update(fetchAdmin);				//updating
				session.getTransaction().commit(); 	//saving to DB
				return fetchAdmin;
			}//else end
			
		}//try end
		catch(HibernateException he) {	//handeling hibernate exception
			JOptionPane.showMessageDialog(null, he);
		}//catch end
		catch(Exception e) {			//handeling all kind of exception
			JOptionPane.showMessageDialog(null, e);
		}//catch end
		return null;
	}

//==========================================================================================================================
	
	//method for deleting admin account
	@Override
	public void deactivateAccount(String username, String password) {
		try{		// activating session
			//fetching admin data
			BankAdmin fetchAdmin = (BankAdmin)session.get(BankAdmin.class, username);
			
			//validations
			//for username
			if( !(admins.stream().anyMatch(x->x.getUsername().equals(username)))  ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid username entry");
			}
			//for password
			else if( !(fetchAdmin.getPassword().equals(password)) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid password entry");
			}
			//if all condition satisfies
			else {
				//it will upadate the value first then will return
				session.beginTransaction();			//activating transaction 
				session.delete(fetchAdmin);			//deleting
				session.getTransaction().commit(); 	//saving changes to DB
				JOptionPane.showMessageDialog(null,"Admin account '" +username+ "' has been deactivated successfully...");
			}
		}// try end
		catch(HibernateException he) {	//handeling hibernate exception
			JOptionPane.showMessageDialog(null, he);
		}//catch end
		catch(Exception e) {			//handeling all kind of exception
			JOptionPane.showMessageDialog(null, e);
		}//catch end	
	}//method end

//==========================================================================================================================	
	
	//method for deleting user account
	@Override
	public void deleteUser(String username, String password, int accountNo) {
		try{		// activating session
			//fetching admin data
			BankAdmin fetchAdmin = (BankAdmin)session.get(BankAdmin.class, username);
			//fetching employee data
			BankUser fetchUser = (BankUser)session.get(BankUser.class, accountNo);
			
			//validations
			//for username
			if( !(admins.stream().anyMatch(x->x.getUsername().equals(username)))  ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid username entry");
			}
			//for password
			else if( !(fetchAdmin.getPassword().equals(password)) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid password entry");
			}
			//if all condition satisfies
			else {
				//it will upadate the value first then will return
				session.beginTransaction();			//activating transaction 
				session.delete(fetchUser);			//deleting
				session.getTransaction().commit(); 	//saving changes to DB
				JOptionPane.showMessageDialog(null,"User account '" +accountNo+ "' has been deactivated successfully...");
			}//else end
		}// try end
		catch(HibernateException he) {	//handeling hibernate exception
			JOptionPane.showMessageDialog(null, he);
		}//catch end
		catch(Exception e) {			//handeling all kind of exception
			JOptionPane.showMessageDialog(null, e);
		}//catch end
	}// method end
	
//==========================================================================================================================	

	//method for deleting employee account
	@Override
	public void deleteEmployee(String adminUsername, String adminPassword, String empUsername) {
		try{		// activating session
			//fetching admin data
			BankAdmin fetchAdmin = (BankAdmin)session.get(BankAdmin.class, adminUsername);
			//fetching employee data
			BankEmployee fetchEmp = (BankEmployee)session.get(BankEmployee.class, empUsername);
			
			//validations
			//for username
			if( !(admins.stream().anyMatch(x->x.getUsername().equals(adminUsername)))  ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid username");
			}
			//for password
			else if( !(fetchAdmin.getPassword().equals(adminPassword)) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid password");
			}
			//if all condition satisfies
			else {
				//it will upadate the value first then will return
				session.beginTransaction();			//activating transaction 
				session.delete(fetchEmp);			//deleting
				session.getTransaction().commit(); 	//saving changes to DB
				JOptionPane.showMessageDialog(null,"Employee account '" +empUsername+ "' has been deactivated successfully...");
			}//else end
		}// try end
		catch(HibernateException he) {	//handeling hibernate exception
			JOptionPane.showMessageDialog(null, he);
		}//catch end
		catch(Exception e) {			//handeling all kind of exception
			JOptionPane.showMessageDialog(null, e);
		}//catch end
	}//method end
//==========================================================================================================================
}
