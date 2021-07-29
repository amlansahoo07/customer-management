package com.rvy.service;

import java.util.List;

import com.rvy.entity.Customer;
import com.rvy.exception.CustomerEntityException;

public interface CustomerService {
	public abstract List<Customer> getAllCustomers() throws CustomerEntityException;
	Customer getDetailsById(Integer id) throws CustomerEntityException;
	Customer addElement(Customer customer) throws CustomerEntityException;
	Customer updateElement(Customer customer) throws CustomerEntityException;
	public abstract Integer deleteElemet(Integer customerId) throws CustomerEntityException; 
}
