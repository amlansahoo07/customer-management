package com.sapient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Customer;
import com.sapient.repository.CustomerRepository;

@Component
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getDetailsById(Integer id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public Customer addElement(Customer customer) {		
		return customerRepository.save(customer);
	}
	
		
}
