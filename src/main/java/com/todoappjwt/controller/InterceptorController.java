package com.todoappjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InterceptorController {
	@GetMapping("/interceptor")
	public static void interceptorMethod() {
		System.out.println("Inside Controller Method. ");
	}

}
