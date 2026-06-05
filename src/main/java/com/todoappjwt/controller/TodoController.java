package com.todoappjwt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoappjwt.Exceptions.TodoNotFoundException;
import com.todoappjwt.dto.TodoDTO;
import com.todoappjwt.entity.ErrorResponse;
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

	//Actuators url - http://localhost:8080/actuator/metrics/http.server.requests?tag=uri:/users/todos&tag=method:GET
	@GetMapping("/todos")
	public ResponseEntity<List<TodoDTO>> getTodosByUsername(Authentication auth){
		String username = auth.getName();
		System.out.println("usrname " + username);
		List<TodoDTO> todos = todoservice.getTodosByUsername(username);
		// .orElseThrow(()-> new TodoNotFoundException("Todo is not enlisted for the user. " + username ));
		if (todos == null || todos.isEmpty()) {
			throw new TodoNotFoundException("Todo is not enlisted for the user. "+username);
		}								
		
		return ResponseEntity.ok(todos);	
		
	}
	//POST - users/${username}/todos/ - changing on branch_two | checking change two | another change third
	//Actuator metric url - /actuator/metrics/http.server.requests?tag=uri:/users/todos&tag=method:POST
	@PostMapping("/todos")
	public ResponseEntity<TodoDTO> createTodo(Authentication auth, @RequestBody TodoDTO todoDTO){
		String username = auth.getName();
		TodoDTO createdTodo = todoservice.createTodo(username, todoDTO);
		return ResponseEntity.status(201).body(createdTodo);
	}
	
	//Delete the Todo - you have to pass the todos/{id} -- you have to pass the id along with the url(we are using the @PathVariable so)
	//Actuators url - http://localhost:8080/actuator/metrics/http.server.requests?tag=uri:/users/todos/%7Bid%7D&tag=method:DELETE
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable Long id, Authentication auth ){
		String username = auth.getName();
		todoservice.deleteTodo(id, username);
		return ResponseEntity.ok("Todo Deleted Successfully ! ");
	}

	@GetMapping("/aspect")
	public ResponseEntity<String> aspectController(){
		System.out.println("aspectContorller inside ! ");
		todoservice.aspect();
		return ResponseEntity.ok("Controller ");
		
	}
	
	
	
	
}
