package com.varxyz.jvx331.customer.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.jvx331.DukeBankTest;

public class CustomerServiceTest extends DukeBankTest{
	
	@Autowired
	private CustomerService customerService;
	
	
	@Test
	public void getAllCustomerList(){
		customerService.getAllCustomerList().forEach(c -> System.out.println(c));
	}
}
