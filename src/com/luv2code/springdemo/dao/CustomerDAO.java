/**
 * Developed by Artur Abratanski
 * based on course: https://www.udemy.com/course/spring-hibernate-tutorial/
 * ended with certificate: https://www.udemy.com/certificate/UC-93a7466f-d55f-4f75-a4f3-58f70e0bb6b1/
 */

/**
 * This is a DAO interface.
 * It declares methods to connect with database. It's a layer between DB and customer.
 */

package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);

}
