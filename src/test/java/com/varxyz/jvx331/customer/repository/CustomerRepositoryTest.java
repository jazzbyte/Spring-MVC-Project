package com.varxyz.jvx331.customer.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.jvx331.DukeBankTest;

public class CustomerRepositoryTest extends DukeBankTest{
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Test
	public void findAll() {
		customerRepo.findAll().forEach(c -> System.out.println(c));
	}
}
