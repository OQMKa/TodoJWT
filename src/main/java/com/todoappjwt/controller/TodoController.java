package com.todoappjwt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoappjwt.dto.TodoDTO;
import com.todoappjwt.entity.Todo;
import com.todoappjwt.service.TodoService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:4200")
public class TodoController {
	private TodoService todoservice ;

	public TodoController(TodoService todoservice) {
		super();
		this.todoservice = todoservice;
	}


	@GetMapping("/todos")
	public ResponseEntity<List<TodoDTO>> getTodosByUsername(Authentication auth){
		String username = auth.getName();
		List<TodoDTO> todos = todoservice.getTodosByUsername(username);
		
		return ResponseEntity.ok(todos);
		
	}
	//POST - users/${username}/todos/ - changing on branch_two | checking change two | another change third
	@PostMapping("/todos")
	public ResponseEntity<TodoDTO> createTodo(Authentication auth, @RequestBody TodoDTO todoDTO){
		String username = auth.getName();
		TodoDTO createdTodo = todoservice.createTodo(username, todoDTO);
		return ResponseEntity.status(201).body(createdTodo);
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable Long id, Authentication auth ){
		String username = auth.getName();
		todoservice.deleteTodo(id, username);
		return ResponseEntity.ok("Todo Deleted Successfully ! ");
	}
}
