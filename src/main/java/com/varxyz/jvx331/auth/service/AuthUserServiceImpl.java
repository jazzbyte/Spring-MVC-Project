package com.varxyz.jvx331.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.jvx331.auth.domain.AuthUser;
import com.varxyz.jvx331.customer.domain.Customer;
import com.varxyz.jvx331.customer.service.CustomerService;


/**
 * 
 * @author Sage R Lee
 *
 */
@Service
public class AuthUserServiceImpl implements AuthUserService{
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 전달된 email을 가진 등록 회원 조회
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public AuthUser getAuthUser(String email) {
		Customer customer = customerService.getCustomerByEmail(email);
		AuthUser user = new AuthUser(customer.getCid(), customer.getEmail(), 
				customer.getName(),	customer.getSsn(), customer.getPhone());
		return user;
	}
	
	
	/**
	 * 등록된 고객인지 확인
	 */
	@Override
	public boolean isValidUser(String email, String passwd) {
		Customer customer = customerService.getCustomerByEmail(email);
		if(customer != null && customer.getPasswd().equals(passwd)) {
			return true;
		}
		return false;
	}
}
