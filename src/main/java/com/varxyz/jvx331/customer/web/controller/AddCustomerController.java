package com.varxyz.jvx331.customer.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.jvx331.customer.domain.Customer;
import com.varxyz.jvx331.customer.service.CustomerService;
import com.varxyz.jvx331.customer.web.command.CustomerCommand;


/**
 * 
 * @author Sage R Lee
 *
 */
@Controller
@RequestMapping("/customer/add")
public class AddCustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	/**
	 * 신규 고객 등록폼
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String addCustomer(Model model){
		model.addAttribute("customer", new CustomerCommand());
		
		return "customer/add_customer";
	}
	
	
	/**
	 * 신규 고객 등록
	 * 
	 * @param customer
	 * @param model
	 * @return
	 */
	@PostMapping
	public String addCustomer(@ModelAttribute("customer") CustomerCommand customer, Model model){
		customer.setEmail(customer.getEmail1() + "@" + customer.getEmail2());
		customer.setSsn(customer.getSsn1() + "-" + customer.getSsn2());
		customer.setPhone(customer.getPhone1() + "-" + customer.getPhone2() 
							+ "-" + customer.getPhone3());
		
		Customer dbCustomer = customerService.addCustomer(customer.buildCustomer());
		model.addAttribute("customer", dbCustomer);
		return "customer/success_add_customer";
	}
	
	/**
	 * e-mail 목록
	 * 
	 * @return
	 */
	@ModelAttribute("emailProviderList")
	public List<EmailProvider> getEmailProviderList(){
		List<EmailProvider> emailProviderList = new ArrayList<EmailProvider>();
		emailProviderList.add(new EmailProvider("Google", "gmail.com"));
		emailProviderList.add(new EmailProvider("Naver", "naver.com"));
		emailProviderList.add(new EmailProvider("Daum", "daum.com"));
		emailProviderList.add(new EmailProvider("MI6", "mi6.org"));
		emailProviderList.add(new EmailProvider("Java", "java.com"));
		
		return emailProviderList;
	}
	
	/**
	 * 전화번호 목록
	 * 
	 * @return
	 */
	@ModelAttribute("phoneProviderList")
	public List<String> getPhoneProviderList(){
		List<String> phoneList = new ArrayList<String>();
		phoneList.add("010");
		phoneList.add("011");
		phoneList.add("016");
		phoneList.add("019");
		phoneList.add("02");
		phoneList.add("053");
		
		return phoneList;
	}
}
