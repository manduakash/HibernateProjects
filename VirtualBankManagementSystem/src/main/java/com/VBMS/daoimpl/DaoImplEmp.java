package com.VBMS.daoimpl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.VBMS.config.HibernateUtil;
import com.VBMS.dao.DaoEmp;
import com.VBMS.entity.BankEmployee;
import com.VBMS.entity.BankUser;
import com.VBMS.exception.GlobalException;

// implementing DaoEmp crud methods
public class DaoImplEmp implements DaoEmp{

	//creating session globally so each and every method can have access of this
	Session session = HibernateUtil.getSession();
		
	//fetching all datas from DB and storing into list reference
	private List<BankUser> users = session.createQuery("FROM BankUser", BankUser.class).getResultList();
	private List<BankEmployee> emps = session.createQuery("FROM BankEmployee", BankEmployee.class).getResultList();
	
//==========================================================================================================================
	
	//method for creating employee account
	@Override
	public void createEmp(BankEmployee emp) {
		try{	//activating session

			//validation of employee details
			//for employee first name
			if( (emp.getFname().length()>10) || (emp.getFname()==null) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid first name entry (Size is more than 10)");
			}
			
			//for employee last name
			if( (emp.getLname().length()>10) || (emp.getLname()==null) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid last name entry (Size is more than 10)");
			}
			
			//for employee username
			else if( (emp.getUsername().length()>15) || (emp.getUsername()==null) || (emps.stream().anyMatch(x->x.getUsername().equals(emp.getUsername()))) ){	
				//it will throw GlobalException
				JOptionPane.showMessageDialog(null,"");
				throw new GlobalException("Invalid username (Username is already taken or there is more than 15 characters.)");
			}
			
			//for employee password
			else if( (emp.getPassword().length()>15) || (emp.getPassword()==null) ){	
				//it will throw GlobalException
				throw new GlobalException("Invalid password (Password should be max 15 characters)");
			}
			
			//if all condition satisfies
			else {
			//adding employee to DB
			session.beginTransaction();
			session.save(emp);
			
			//saving to DB
			session.getTransaction().commit();
			JOptionPane.showMessageDialog(null,"Employee account '"+emp.getUsername()+"' has been created successfully.");
			}
			session.clear();
		}catch(HibernateException he) {	//handeling hibernate exception
			JOptionPane.showMessageDialog(null, he);
		}catch(Exception e) {			//handeling all kind of exception
			JOptionPane.showMessageDialog(null, e);
		}//end catch
		}//end method
	
//==========================================================================================================================

	//method for fetching all employee details
	@Override
	public List<BankUser> fetchAllUsers(String username, String password) {
		try{	//activating session
			//fetching employee data
			BankEmployee fetchEmp = (BankEmployee)session.get(BankEmployee.class, username);
			
			//validations
			//for username
			if( !(emps.stream().anyMatch(x->x.getUsername().equals(username)))  ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid username entry");
			}
			//for password
			else if( !(fetchEmp.getPassword().equals(password)) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid password entry");
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
	}//end method

//==========================================================================================================================
	
	//method for updating password
	@Override
	public BankEmployee changePassword(String username, String password, BankEmployee emp) {
		try{	//activating session
			//fetching employee data
			BankEmployee fetchEmp = (BankEmployee)session.get(BankEmployee.class,username);
			
			//validations
			//for username
			if( !(emps.stream().anyMatch(x->x.getUsername().equals(username)))  ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid username entry");
			}
			//for password
			else if( !(fetchEmp.getPassword().equals(password)) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid password entry");
			}
			//if all condition satisfies
			else {
				//setting updated values
				fetchEmp.setPassword(emp.getPassword());
				//it will upadate the value first then will return
				session.beginTransaction();			//activating transaction 
				session.update(fetchEmp);				//updating
				session.getTransaction().commit(); 	//saving to DB
				return fetchEmp;
			}
			
		}catch(HibernateException he) {	//handeling hibernate exception
			JOptionPane.showMessageDialog(null, he);
		}catch(Exception e) {			//handeling all kind of exception
			JOptionPane.showMessageDialog(null, e);
		}//end catch	
		return null;
	}//end method

//==========================================================================================================================
	
	//method for deleting existing employee account
	@Override
	public void deactivateAccount(String username, String password) {
		try{		// activating session
			//fetching employee data
			BankEmployee fetchEmp = (BankEmployee)session.get(BankEmployee.class, username);
			
			//validations
			//for username
			if( !(emps.stream().anyMatch(x->x.getUsername().equals(username)))  ) {
				///it will throw GlobalException
				throw new GlobalException("Invalid username entry");
			}
			//for password
			else if( !(fetchEmp.getPassword().equals(password)) ) {
				//it will throw GlobalException
				throw new GlobalException("Invalid password entry");
			}
			//if all condition satisfies
			else {
				//it will upadate the value first then will return
				session.beginTransaction();			//activating transaction 
				session.delete(fetchEmp);			//deleting
				session.getTransaction().commit(); 	//saving changes to DB
				JOptionPane.showMessageDialog(null,"Employee account '" +username+ "' has been deactivated successfully...");
			}
		}// try end
		catch(HibernateException he) {	//handeling hibernate exception
			JOptionPane.showMessageDialog(null, he);
		}//catch end
		catch(Exception e) {			//handeling all kind of exception
			JOptionPane.showMessageDialog(null, e);
		}//catch end
	}//end method

//==========================================================================================================================

}
