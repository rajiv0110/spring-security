package com.rajiv.spring.security.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/signin")
	public String signin() {
		return "login";
	}
}
