package com.feliphe.springdemo.service;

import java.util.List;

import com.feliphe.springdemo.entity.Customer;

public interface ICustomerService {
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);

}
