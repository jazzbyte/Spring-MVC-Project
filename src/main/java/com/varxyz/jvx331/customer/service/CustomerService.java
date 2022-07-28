package com.varxyz.jvx331.customer.service;

import java.util.List;

import com.varxyz.jvx331.customer.domain.Customer;

public interface CustomerService {

	/**
	 * 신규 고객 등록
	 * 
	 * @param customer
	 * @return
	 */
	Customer addCustomer(Customer customer);

	/**
	 * 전체 고객 목록 조회
	 * @return
	 */
	List<Customer> getAllCustomerList();

	/**
	 * 전달된 email을 가진 고객 조회
	 * 
	 * @param email
	 * @return
	 */
	Customer getCustomerByEmail(String email);

}
