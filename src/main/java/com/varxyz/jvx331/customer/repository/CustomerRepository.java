package com.varxyz.jvx331.customer.repository;

import java.util.List;

import com.varxyz.jvx331.customer.domain.Customer;

public interface CustomerRepository {
	
	Customer save(Customer custome);
	
	Customer findBySsn(String ssn);
	
	List<Customer> findByPhone(String phone);

	List<Customer> findAll();

	Customer findByEmail(String email);
}
