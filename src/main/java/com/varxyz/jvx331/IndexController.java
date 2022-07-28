package com.varxyz.jvx331;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.varxyz.jvx331.account.service.AccountService;
import com.varxyz.jvx331.auth.web.UserContainer;

@Controller
public class IndexController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/")
	public String index(@SessionAttribute(required = false) UserContainer userContainer) {
		if(userContainer == null) {
			return "index";
		}
		userContainer.setAccountList(accountService.getAccountList(
									userContainer.getAuthUser().getUid()));
		return "index";
	}
}
