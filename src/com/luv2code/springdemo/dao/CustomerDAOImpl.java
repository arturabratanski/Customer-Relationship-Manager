/**
 * Developed by Artur Abratanski
 * based on course: https://www.udemy.com/course/spring-hibernate-tutorial/
 * ended with certificate: https://www.udemy.com/certificate/UC-93a7466f-d55f-4f75-a4f3-58f70e0bb6b1/
 */

/**
 * This is a DAO implementation class.
 * It codes all methods delcared by interface, we use standard session factory in this case.
 */

package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query... sort by last name
		Query<Customer> theQuery = currentSession.createQuery(
				"from Customer order by lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the customer... finally
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer tempCustomer = currentSession.get(Customer.class, theId);
		
		return tempCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now delete object with primary key
		Query theQuery = currentSession.createQuery(
				"delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		// only search by name if theSearchName is not empty
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			
			// search for firstName or lastName... case insensitive
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like "
					+ ":theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			
			// theSearchName is empty... so just get all customers
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

}
