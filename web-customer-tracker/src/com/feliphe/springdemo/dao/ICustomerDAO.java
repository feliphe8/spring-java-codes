package com.feliphe.springdemo.dao;

import java.util.List;

import com.feliphe.springdemo.entity.Customer;

public interface ICustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);
}
