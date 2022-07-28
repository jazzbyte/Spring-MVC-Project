package com.varxyz.jvx331.account.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.varxyz.jvx331.account.service.AccountService;
import com.varxyz.jvx331.auth.web.UserContainer;

@Controller
public class ListAccountsController {

	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/account/mylist")
	public String getMyAccount(@SessionAttribute UserContainer userContainer, Model model) {
		model.addAttribute("myAccounts", userContainer.getAccountList());
		return "account/list_my_accounts";
	}
}
