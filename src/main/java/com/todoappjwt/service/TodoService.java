package com.todoappjwt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todoappjwt.dto.TodoDTO;
import com.todoappjwt.entity.Todo;
import com.todoappjwt.repository.TodoRepository;

@Service
public class TodoService {
	private TodoRepository repo;
	
	public TodoService(TodoRepository repo) {
		System.out.println("metadata(@Serice, @RestContorller, @Repository) IN ***com.todoappjwt*** are scanned by @ComponentScan");
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
	public void deleteTodo(Long id, String username) {
		// TODO Auto-generated method stub
		Todo todo = repo.findById(id)
					.orElseThrow(()->new RuntimeException("Todo not found !"));
		//OwnerShip check
		if(!todo.getUsername().equals(username)) {
			throw new RuntimeException("You are not authorized to delete this todo !");
		}
		repo.delete(todo);
	}
	//trying for @aspect and @PointCut, Designators(-@Within, Within, @Target, Target)
	public ResponseEntity<String> aspect(){
		System.out.println("aspect method in todoservice.");
		return ResponseEntity.ok("Service");
	}

}
