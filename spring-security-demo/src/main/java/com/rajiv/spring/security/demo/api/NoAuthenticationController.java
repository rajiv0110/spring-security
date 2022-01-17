package com.rajiv.spring.security.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class NoAuthenticationController {

	@GetMapping("/home")
	public String getHomePage() {
		return "This is home page";
	}

	@GetMapping("/register")
	public String getRegisterPage() {
		return "This is register page";
	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "This is login page";
	}
}
