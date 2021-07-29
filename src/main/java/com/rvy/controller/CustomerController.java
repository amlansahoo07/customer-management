package com.rvy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.rvy.entity.Customer;
import com.rvy.entity.PurchaseHistory;
import com.rvy.exception.CustomerEntityException;
import com.rvy.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cm/v1")
@Api
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@ApiOperation (value = "Find All Customers",			
			produces = "List of Customers",
			response = Customer.class,
			tags = "findAllCustomer",
			notes = "http://localhost:9003/rvy/api/cm/v1/customers"
			)
	@GetMapping("/customers")
	public ResponseEntity<List<Customer> > getCustomers() throws CustomerEntityException{
		try {
			List<Customer> customerList = customerService.getAllCustomers();
			return new ResponseEntity<>(customerList,HttpStatus.OK);
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@ApiOperation (value = "Find Customer By Id",			
			produces = "Customer Id",
			response = Customer.class,
			tags = "findCustomer",
			notes = "http://localhost:9003/rvy/api/cm/v1/customers/1"
			)
	// http://localhost:9003/cc/c1/getid/5012
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer>  getCustomers(@PathVariable("customerId") Integer customerId) throws CustomerEntityException{
		try {
			Customer customer =  customerService.getDetailsById(customerId);
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@ApiOperation (value = "Insert Customer",			
			produces = "Customer Object",
			response = Customer.class,
			tags = "insertCustomer",
			notes = "http://localhost:9003/rvy/api/cm/v1/customers"
			)
	
	@PostMapping("/customers")
	public ResponseEntity<Customer>  addCustomer(@Valid @RequestBody Customer customer,
			BindingResult bindingResult) throws Exception,CustomerEntityException {		
		try
		{
			if(bindingResult.hasErrors())
				throw new Exception(bindingResult.getAllErrors().toString());
			Customer customerFromDb = customerService.addElement(customer);
			return ResponseEntity.ok().body(customerFromDb);
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@ApiOperation (value = "Update Customer",			
			produces = "Customer Object",
			response = Customer.class,
			tags = "updateCustomer",
			notes = "http://localhost:9003/rvy/api/cm/v1/customers"
			)
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) throws Exception{
		
		try
		{
			if(bindingResult.hasErrors())
				throw new Exception(bindingResult.getAllErrors().toString());
				
			Customer customerUpdated = customerService.updateElement(customer);
			return ResponseEntity.ok(customerUpdated);
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@ApiOperation (value = "Delete Customer",			
			produces = "Customer Object",
			response = Customer.class,
			tags = "deleteCustomer",
			notes = "http://localhost:9003/rvy/api/cm/v1/customers/1"
			)
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Integer> deleteCustomer(@PathVariable("customerId") Integer customerId) throws CustomerEntityException{
		try{
			Integer deleted= customerService.deleteElemet(customerId);
			return ResponseEntity.ok(deleted);
			
		}catch(ResponseStatusException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
			}
		}
	
	
	
}
