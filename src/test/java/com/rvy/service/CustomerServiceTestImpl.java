package com.rvy.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rvy.entity.Customer;
import com.rvy.repository.CustomerRepository;
import com.rvy.service.CustomerService;
import com.rvy.service.CustomerServiceImpl;


@ExtendWith(SpringExtension.class)
class CustomerServiceTestImpl {

	@TestConfiguration
	static class RestaurantServiceImplTestContextConfiguration {
		@Bean
		public CustomerService Service() {
			return new CustomerServiceImpl();
		}
	}

	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private CustomerRepository repository;
	
	@BeforeEach
	public void dummyManagement() {

			Customer cust1 = new Customer(1211,"Alfred Novel","alfred@amazon.com",7898989890L,216,LocalDate.of(1999, 1, 9),"Vyasanagar","Paharganj");
			Customer cust2 = new Customer(4007,"Anne Hathaway","annahath@hollywood.com",7966478895L,210,LocalDate.of(1998, 11, 8),"Shimla","Mars");
			Customer cust3 =						
					new Customer(2164,"August Kennedy","august@september.ac.in",9877895632L,272,LocalDate.of(2004, 4, 5),"Ranital","Mayurbhanj");
							
				
			List<Customer> customerList = Arrays.asList(cust1,cust2,cust3);	
			
			Mockito.when(repository.findById(-11)).thenReturn(null);
			Mockito.when(repository.findByName("William Shakespeare")).thenReturn(null);

			Mockito.when(repository.findById(cust1.getCustomerId())).thenReturn(Optional.of(cust1));
			Mockito.when(repository.findAll()).thenReturn(customerList);
			Mockito.when(repository.findById(108)).thenReturn(Optional.empty());
			Mockito.when(repository.findByName("Anne Hathaway")).thenReturn(Optional.of(cust2).get());//.collect(Collectors.toList()));
				
				
				
				
	}
	
	@Test
	public void validNameFromId() {
		Customer testCust;
		try {
			testCust = repository.findById(4007).get();
			assertThat(testCust.getName()=="August Kennedy");
			assertThat(testCust.getAddress1()=="Shimla");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void InValidIdCheck() {
		Customer customer;
		try {
			customer = repository.findById(-11).get();
			assertThat(customer).isNull();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	

}
