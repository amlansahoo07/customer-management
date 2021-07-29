package com.sapient.service;

import java.util.List;

import com.sapient.entity.Customer;

public interface CustomerService {
	public abstract List<Customer> getAllCustomers();
	Customer getDetailsById(Integer id);
	Customer addElement(Customer customer);
}
