/**
 * Developed by Artur Abratanski
 * based on course: https://www.udemy.com/course/spring-hibernate-tutorial/
 * ended with certificate: https://www.udemy.com/certificate/UC-93a7466f-d55f-4f75-a4f3-58f70e0bb6b1/
 */

/**
 * This is a service implementation class.
 * It handles all transaction settings, DB operations are delegated to DAO.
 */

package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	// it'll handle transaction, not CustomerDAO
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// delegate to CustomerDAO method
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		
		return customerDAO.searchCustomers(theSearchName);
	}

}
