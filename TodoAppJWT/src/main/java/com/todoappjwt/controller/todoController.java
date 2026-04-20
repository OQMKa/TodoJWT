package com.todoappjwt.controller;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoappjwt.DTO.LoginUserParameters;
import com.todoappjwt.service.TodoService;

@RestController
@RequestMapping
public class todoController {
	private TodoService service;
	
	public todoController(TodoService service) {
		this.service = service;
	}

	
}
