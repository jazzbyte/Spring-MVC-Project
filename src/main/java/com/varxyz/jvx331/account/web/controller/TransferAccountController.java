package com.varxyz.jvx331.account.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.varxyz.jvx331.account.domain.Account;
import com.varxyz.jvx331.account.service.AccountService;
import com.varxyz.jvx331.account.web.command.TransferCommand;
import com.varxyz.jvx331.auth.web.UserContainer;

@Controller
public class TransferAccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/account/transfer")
	public String transferForm(@RequestParam String accountNum, Model model) {
		Account account = accountService.getAccountByAccountNum(accountNum);
		List<Account> accountList = accountService.getAccountList();
		model.addAttribute("from", account);
		model.addAttribute("toList", accountList);
		
		return "account/transfer_account";
	}
	
	
	@PostMapping("/account/transfer")
	public String transfer(TransferCommand transferCommand, 
						@SessionAttribute UserContainer userContainer,
						RedirectAttributes model) {
		System.out.println("transferCommand : " + transferCommand);
		
		String fromNum = transferCommand.getFromAccountNum();
		
		//1. 비밀번호 확인
		Account account = accountService.getAccountByAccountNum(fromNum);
		if(!account.getPasswd().equals(transferCommand.getPasswd())){
			
		}
		//2. 이체 처리
		try {
			accountService.transfer(transferCommand.getAmount(), 
					transferCommand.getFromAccountNum(), 
					transferCommand.getToAccountNum());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Account updatedAccount = accountService.getAccountByAccountNum(fromNum);
		
		//3. userContainer 적용
		userContainer.getAccount(fromNum)
					.setBalance(updatedAccount.getBalance());
		
		//4. 뒤로금지
		model.addFlashAttribute("account", updatedAccount);
		return "redirect:/account/transfer/success";
	}
	
	@GetMapping("/account/transfer/success")
	public String successTransfer() {
		return "account/success_transfer_account";
	}
	
	
	/**
	 * 받는 계좌에 대한 계좌주 확인
	 *  
	 * @param accountNum
	 * @return
	 */
	@GetMapping("/account/receiver/check/{accountNum}")
	public ResponseEntity<?> checkReceiverName(@PathVariable String accountNum){
		Account account = accountService.getAccountByAccountNum(accountNum);
		if(account == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(account.getCustomer().getName());
	}
}
