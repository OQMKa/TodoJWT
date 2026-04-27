package com.todoappjwt.entity;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "todos")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String username;
	
	
	
	private String description;
	
	private String priority;
	
	
	private boolean done;
	
	
	private LocalDate targetDate;
	
	public Todo() {}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public boolean isDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}


	public LocalDate getTargetDate() {
		return targetDate;
	}


	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}


	public Todo(long id, @NotBlank String username, String description, String priority, boolean done,
			LocalDate targetDate) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.priority = priority;
		this.done = done;
		this.targetDate = targetDate;
	}


	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", priority=" + priority
				+ ", done=" + done + ", targetDate=" + targetDate + "]";
	}
	


	
	
	


	

	
	
	
	
}
