package com.varxyz.jvx331.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.jvx331.customer.domain.Customer;
import com.varxyz.jvx331.customer.repository.CustomerRepository;
import com.varxyz.jvx331.exception.CustomerNotFoundException;


/**
 * 고객 정보 관리
 * 
 * @author Sage R Lee
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepo;
	
	/**
	 * 신규 고객 등록
	 * 
	 * @param customer
	 * @return
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	/**
	 * 전체 고객 목록 조회
	 * @return
	 */
	@Override
	public List<Customer> getAllCustomerList(){
		return customerRepo.findAll();
	}
	
	/**
	 * 전달된 email을 가진 고객 조회
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public Customer getCustomerByEmail(String email) {
		Customer customer = customerRepo.findByEmail(email);
		return customer;
	}
	
	
	/**
	 * 연락처로 고객 검색
	 * @param phone
	 * @return
	 */
	public List<Customer> searchCustomerByPhone(String phone){
		return customerRepo.findByPhone(phone);
	}
	/**
	 * ssn으로 고객 검색
	 * 
	 * @param ssn
	 * @return
	 */
	public Customer searchCustomerBySsn(String ssn) {
		Customer customer = customerRepo.findBySsn(ssn);
		if(customer == null || customer.getCid() == 0) {
			throw new CustomerNotFoundException(ssn);
		}
		return customer;
	}
	
	
}
