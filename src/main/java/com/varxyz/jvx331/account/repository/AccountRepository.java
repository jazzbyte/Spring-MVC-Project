package com.varxyz.jvx331.account.repository;

import java.util.List;

import com.varxyz.jvx331.account.domain.Account;

public interface AccountRepository {

	Account save(Account account);
	
	Account findByAccountNum(String accountNum);

	List<Account> findByCustomerId(long customerId);

	List<Account> findAll();

	void updateBalance(double balance, String accountNum);

}
