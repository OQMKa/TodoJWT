package com.todoappjwt.service;

import org.springframework.stereotype.Service;

import com.todoappjwt.repository.LoginUserRepo;

@Service
public class LoginUserDataService {
	private LoginUserRepo repo;

	public LoginUserDataService(LoginUserRepo loginUserRepo) {
		this.repo = loginUserRepo;
	}
	
}
