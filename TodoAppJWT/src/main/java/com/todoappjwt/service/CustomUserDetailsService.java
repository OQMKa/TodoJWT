package com.todoappjwt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.todoappjwt.entity.LoginUserParameters;
import com.todoappjwt.repository.LoginUserRepo;
import java.util.*;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	private final LoginUserRepo repo;

	public CustomUserDetailsService(LoginUserRepo repo) {
		this.repo = repo;
	}
	@Override
	public UserDetails loadUserByUsername(String username) {
		LoginUserParameters user = repo.findByUsername(username)
									.orElseThrow(()-> new RuntimeException("No user found!"));
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles("USER")
				.build();
	}
}
