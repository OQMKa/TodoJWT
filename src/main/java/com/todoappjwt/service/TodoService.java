package com.todoappjwt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todoappjwt.dto.TodoDTO;
import com.todoappjwt.entity.Todo;
import com.todoappjwt.repository.TodoRepository;

@Service
public class TodoService {
	private TodoRepository repo;
	
	public TodoService(TodoRepository repo) {
		System.out.println("SERVICE CREATED");
		this.repo = repo;
	}
	public List<TodoDTO> getTodosByUsername(String username) {
		// TODO Auto-generated method stub
		List<Todo> todos = repo.findByUsername(username);
		
		return todos.stream()
				.map(this::mapToDTO)
				.toList();
	}
	private TodoDTO mapToDTO(Todo todo) {
		TodoDTO dto = new TodoDTO();
		dto.setId(todo.getId());
		dto.setUsername(todo.getUsername());
		dto.setDescription(todo.getDescription());
		dto.setPriority(todo.getPriority());
		dto.setDone(todo.isDone());
		dto.setTargetDate(todo.getTargetDate());
		return dto;
	}
	public TodoDTO createTodo(String username, TodoDTO todoDTO) {
		// TODO Auto-generated method stub
		Todo todo = new Todo();
		todo.setUsername(username);
		todo.setDescription(todoDTO.getDescription());
		todo.setPriority(todoDTO.getPriority());
		todo.setDone(todoDTO.isDone());
		todo.setTargetDate(todoDTO.getTargetDate());
		
		Todo savedTodo = repo.save(todo);
		
		return mapToDTO(savedTodo);
	}

}
