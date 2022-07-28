package com.varxyz.jvx331.customer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.jvx331.customer.service.CustomerService;

@Controller
public class ListCustomersController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customer/list")
	public String listCustomers(Model model) {
		model.addAttribute("customerList", customerService.getAllCustomerList());
		return "customer/list_customers";
	}
}
