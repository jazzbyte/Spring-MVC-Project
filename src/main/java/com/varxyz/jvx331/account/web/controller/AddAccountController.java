package com.varxyz.jvx331.account.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.varxyz.jvx331.account.domain.Account;
import com.varxyz.jvx331.account.domain.CheckingAccount;
import com.varxyz.jvx331.account.domain.SavingsAccount;
import com.varxyz.jvx331.account.service.AccountService;
import com.varxyz.jvx331.account.web.command.AccountCommand;
import com.varxyz.jvx331.auth.web.UserContainer;
import com.varxyz.jvx331.customer.domain.Customer;

@Controller
public class AddAccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account/open")
	public String openNewAccountForm(@ModelAttribute("account") 
									AccountCommand accountCommand) {
		return "account/open_account";
	}
	
	@PostMapping("/account/open")
	public String openNewAccount(AccountCommand accountcommand, 
								@SessionAttribute UserContainer userContainer,  
								Model model) {
		Account account = null;
		if(accountcommand.getAccountType() == 'S') {
			account = new SavingsAccount();
		}else {
			account = new CheckingAccount();
		}
		account.setAccountNum(accountService.generateAccountNum());
		account.setAccountType(accountcommand.getAccountType());
		account.setBalance(accountcommand.getBalance());
		account.setCustomer(new Customer(accountcommand.getCustomer().getId()));
		account.setPasswd(accountcommand.getPasswd());
		
		Account dbAccount = accountService.openNewAccount(account);
		userContainer.addAccount(dbAccount);
		model.addAttribute("account", dbAccount);
		
		return "account/success_open_account";
	}
	
	@ModelAttribute("accountTypeList")
	public List<AccountType> getAccountTypeList(){
		List<AccountType> accountTypeList = new ArrayList<AccountType>();
		accountTypeList.add(new AccountType('S', "SavingsAccount"));
		accountTypeList.add(new AccountType('C', "CheckingAccount"));
		
		return accountTypeList;
	}
	
	
	
}
