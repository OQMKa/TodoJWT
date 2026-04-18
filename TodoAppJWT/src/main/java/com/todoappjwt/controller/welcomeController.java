package com.todoappjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class welcomeController {
	@GetMapping("/greet")
	public String greet() {
		return "connected!";
	}
	

}
