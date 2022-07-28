package com.varxyz.jvx331.auth.web;

import java.util.List;

import org.springframework.context.annotation.Scope;

import com.varxyz.jvx331.account.domain.Account;
import com.varxyz.jvx331.auth.domain.AuthUser;

import lombok.Getter;
import lombok.Setter;

@Scope("session")
@Getter
@Setter
public class UserContainer {
	private AuthUser authUser;
	private List<Account> accountList;
	
	public Account getAccount(String accountNum) {
		if(accountList == null ) {
			return null;
		}
		
		for(Account account : accountList) {
			if(account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		return null;
	}
	
	public void addAccount(Account account) {
		accountList.add(account);
	}
}
