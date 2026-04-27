package com.todoappjwt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todoappjwt.dto.TodoDTO;
import com.todoappjwt.entity.Todo;
import com.todoappjwt.repository.TodoRepository;

@Service
public class TodoService {
	private TodoRepository repo;
	
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

}
