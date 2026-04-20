package com.todoappjwt.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.todoappjwt.DTO.LoginUserParameters;
import com.todoappjwt.repository.LoginUserRepo;

@Service
public class TodoService {
	private LoginUserRepo repo;

	public TodoService(LoginUserRepo repo) {
		this.repo = repo;
	}

}
