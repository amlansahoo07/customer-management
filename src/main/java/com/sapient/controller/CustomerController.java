package com.sapient.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sapient.entity.Customer;
import com.sapient.service.CustomerService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/cc")
@Api
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer> > getCustomers(){
		try {
			List<Customer> customerList = customerService.getAllCustomers();
			return (ResponseEntity<List<Customer>>) customerList;
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@GetMapping("/getid/{customerId}")
	public ResponseEntity<Customer>  getCustomers(@PathVariable("customerId") Integer customerId){
		try {
			Customer customer =  customerService.getDetailsById(customerId);
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@PostMapping("/pushinto")
	public ResponseEntity<Customer>  addCustomer(@Valid @RequestBody Customer customer,
			BindingResult bindingResult) throws Exception{
			
		if(bindingResult.hasErrors())
				throw new Exception(bindingResult.getAllErrors().toString());
		
		Customer customerFromDb = customerService.addElement(customer);
		return ResponseEntity.ok().body(customerFromDb);
	}
}
