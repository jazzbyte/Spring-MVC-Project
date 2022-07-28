package com.varxyz.jvx331.account.service;

import java.util.List;

import com.varxyz.jvx331.account.domain.Account;

public interface AccountService {

	Account openNewAccount(Account account);

	Account getAccountByAccountNum(String accountNum);

	List<Account> getAccountList(long customerId);
	
	List<Account> getAccountList();

	void transfer(double amount, String fromAccountNum, String toAccountNum);

	void updateBalance(double balance, String accountNum);

	/**
	 * 123-56-8901 형태를 가진 임의의 AccountNum 생성
	 * @return
	 */
	String generateAccountNum();

}
