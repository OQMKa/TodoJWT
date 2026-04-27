package com.todoappjwt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.todoappjwt.dto.TodoDTO;
import com.todoappjwt.entity.Todo;
import com.todoappjwt.service.TodoService;

@RestController("/users")
public class TodoController {
	private TodoService todoservice ;

	public TodoController(TodoService todoservice) {
		super();
		this.todoservice = todoservice;
	}


	@GetMapping("/{username}/todos")
	public ResponseEntity<List<TodoDTO>> getTodosByUsername(@PathVariable String username){
		List<TodoDTO> todos = todoservice.getTodosByUsername(username);
		
		return ResponseEntity.ok(todos);
		
	}
	//POST - users/${username}/todos/ - changing on branch_two
}
