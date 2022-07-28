package com.varxyz.jvx331.auth.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.jvx331.auth.service.AuthUserService;
import com.varxyz.jvx331.auth.web.UserContainer;

@Controller
public class LogInOutController {
	
	@Autowired
	private AuthUserService authUserService;
	
	@GetMapping("/auth/login")
	public String loginForm() {
		return "auth/login";
	}
	
	@PostMapping("/auth/login")
	public String login(@RequestParam String email, @RequestParam String passwd, HttpSession session) {
		if(!authUserService.isValidUser(email, passwd)) {
			String errorMsg = "등록되지 않은 계정이거나 비밀번호가 맞지 않습니다.";
			session.setAttribute("errorMsg", errorMsg);
			return "redirect:/auth/login";
		}
		UserContainer userContainer = new UserContainer();
		userContainer.setAuthUser(authUserService.getAuthUser(email));
		session.setAttribute("userContainer", userContainer);
		
		return "redirect:/"; 	
	}
	
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userContainer");
		session.invalidate();
		
		return "redirect:/";
	}
}
