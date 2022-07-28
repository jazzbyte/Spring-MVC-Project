package com.varxyz.jvx331.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varxyz.jvx331.account.domain.Account;
import com.varxyz.jvx331.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public Account openNewAccount(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Account getAccountByAccountNum(String accountNum) {
		return accountRepo.findByAccountNum(accountNum);
	}

	@Override
	public List<Account> getAccountList(long customerId) {
		return accountRepo.findByCustomerId(customerId);
	}

	@Override
	public List<Account> getAccountList() {
		return accountRepo.findAll();
	}

	@Override
	@Transactional
	public void transfer(double amount, String fromAccountNum, String toAccountNum) {
		Account from = getAccountByAccountNum(fromAccountNum);
		Account to = getAccountByAccountNum(toAccountNum);
		
		from.withdraw(amount);
		to.deposit(amount);
		
		updateBalance(from.getBalance(), from.getAccountNum());
		updateBalance(to.getBalance(), to.getAccountNum());
	}
	
	@Override
	@Transactional
	public void updateBalance(double balance, String accountNum) {
		accountRepo.updateBalance(balance, accountNum);
	}
	
	/**
	 * 123-56-8901 형태를 가진 임의의 AccountNum 생성
	 * @return
	 */
	@Override
	public String generateAccountNum() {
		String numStr = String.valueOf((int)(Math.random() * 1000000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0, 3));
		sb.append("-");
		sb.append(numStr.substring(3, 5));
		sb.append("-");
		sb.append(numStr.substring(5));
		
		return sb.toString();
	}
}
