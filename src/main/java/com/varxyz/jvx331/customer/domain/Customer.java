package com.varxyz.jvx331.customer.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
	private long cid;
	private String email;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private Date regDate;
	
	public Customer() {
		super();
	}
	
	public Customer(long cid) {
		this.cid = cid;
	}
	
	public Customer(long cid, String email, String passwd, String name, 
					String ssn, String phone, Date regDate) {
		super();
		this.cid = cid;
		this.email = email;
		this.passwd = passwd;
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.regDate = regDate;
	}
	
	
}
