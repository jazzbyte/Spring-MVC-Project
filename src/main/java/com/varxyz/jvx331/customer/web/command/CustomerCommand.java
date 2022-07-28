package com.varxyz.jvx331.customer.web.command;

import com.varxyz.jvx331.customer.domain.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCommand {
	private long id;
	private String email;
	private String email1;
	private String email2 = "naver.com";
	
	private String passwd;
	private String name;
	
	private String ssn;
	private String ssn1;
	private String ssn2;
	
	private String phone;
	private String phone1;
	private String phone2;
	private String phone3;
	
	public CustomerCommand(){
		
	}
	
	public CustomerCommand(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [email1=" + email1 + ", passwd=" + passwd + ", name="
				+ name + ", ssn1=" + ssn1 + ", ssn2=" + ssn2 + ", email1="
				+ email1 + ", email2=" + email2 + ", phone1=" + phone1
				+ ", phone2=" + phone2 + ", phone3=" + phone3 + "]";
	}
	
	public Customer buildCustomer() {
		Customer cust = new Customer();
		cust.setEmail(email);
		cust.setName(name);
		cust.setPasswd(passwd);
		cust.setPhone(phone);
		cust.setSsn(ssn);
		
		return cust;
	}
}
