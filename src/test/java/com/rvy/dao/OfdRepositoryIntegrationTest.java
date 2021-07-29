package com.rvy.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rvy.CustomerSupermarketAppApplication;
import com.rvy.entity.Customer;
import com.rvy.repository.CustomerRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { CustomerSupermarketAppApplication.class })

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class OfdRepositoryIntegrationTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private CustomerRepository repository;
	
    @Test
    public void whenFindByAddress_thenReturnAddress() {
        Customer customer = new Customer(1899,"Badal","badalsahoo@gmail.com",977717224L,95,LocalDate.of(2016, 1, 5),"Kuala Lumpur","Mg Road");
        entityManager.persistAndFlush(customer);

        Customer customerDB = repository.findByName(customer.getName());
        	assertThat(customerDB.getAddress1()).isEqualTo(customer.getAddress1());  

    }

    
    
    
    
    @Test
    public void whenInvalidContactDetails_thenReturnNull() {
    		Customer cust = repository.findByName("Trojan Virus");
    		List<Customer> custList = new ArrayList<>();
    		if(cust!=null)custList.add(cust);
    		assertThat(custList).isEmpty();
    }
    
    @Test
    public void whenFindById_thenReturnRestaurnt() {
        Customer customer = new Customer(1899,"Badal","badalsahoo@gmail.com",977717224L,95,LocalDate.of(2016, 1, 5),"Kuala Lumpur","Mg Road");
        entityManager.persistAndFlush(customer);

       	Customer fromDb = repository.findById(customer.getCustomerId())
        										.orElse(null);
        assertThat(fromDb.getCustomerId()).isEqualTo(customer.getCustomerId());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
    	Customer fromDb = repository.findById(-11).orElse(null);
        assertThat(fromDb).isNull();
    }

}
