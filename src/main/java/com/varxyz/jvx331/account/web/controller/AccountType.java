package com.varxyz.jvx331.account.web.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountType {
	private char accountType;
	private String accountName;
	
	public AccountType(char accountType, String accountName) {
		super();
		this.accountType = accountType;
		this.accountName = accountName;
	}
}
