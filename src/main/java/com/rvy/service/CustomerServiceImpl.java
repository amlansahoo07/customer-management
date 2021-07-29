package com.rvy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rvy.entity.Customer;
import com.rvy.exception.CustomerEntityException;
import com.rvy.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() throws CustomerEntityException{
		try{
			return customerRepository.findAll();
		}catch (Exception e) {
			throw new CustomerEntityException(e.getMessage(),e);
		}
	}

	@Override
	public Customer getDetailsById(Integer id) throws CustomerEntityException{
		try{
			return customerRepository.findById(id).get();
		}catch (Exception e) {
			throw new CustomerEntityException(e.getMessage(),e);
		}
	}

	@Override
	public Customer addElement(Customer customer) throws CustomerEntityException{		
		try{
			return customerRepository.save(customer);
		}catch (Exception e) {
			throw new CustomerEntityException(e.getMessage(),e);
		}
	}

	@Override
	public Customer updateElement(Customer customer) throws CustomerEntityException{		
		try{
			return customerRepository.save(customer);
		} catch (Exception e) {
			throw new CustomerEntityException(e.getMessage(),e);
		}
	}

	@Override
	public Integer deleteElemet(Integer customerId) throws CustomerEntityException{
		try{
			Customer customer = customerRepository.findById(customerId).get();
			customerRepository.delete(customer);
			return customerId;
		}catch (Exception e) {
			throw new CustomerEntityException(e.getMessage(),e);
		}
	}
	
		
}
