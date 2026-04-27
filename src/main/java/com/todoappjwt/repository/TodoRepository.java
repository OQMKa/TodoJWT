package com.todoappjwt.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.todoappjwt.entity.Todo;

@Repository
public interface TodoRepository {

	List<Todo> findByUsername(String username);

//	List<Todo> findByUsername(String username);

}
