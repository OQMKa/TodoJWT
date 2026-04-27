package com.todoappjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoappjwt.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	List<Todo> findByUsername(String username);

//	List<Todo> findByUsername(String username);

}
