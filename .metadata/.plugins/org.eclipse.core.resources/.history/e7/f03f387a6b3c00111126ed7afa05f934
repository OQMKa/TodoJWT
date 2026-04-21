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
		super();
		this.service = service;
	}

	@GetMapping("/users/{username}/todos")
	public ResponseEntity<List<LoginUserParameters>> getAllTodos(@PathVariable String username){
		List<LoginUserParameters> todos = service.findAll(username);
		if(todos==null||todos.isEmpty()) {
			return ResponseEntity.noContent().build(); //204 no content present for given username
		}
		return ResponseEntity.ok(todos);//200 ok
	}
}
