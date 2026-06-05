package com.unwanted;

import org.springframework.stereotype.Service;

@Service
public class Unwanted {
	public Unwanted() {
		System.out.println("metadata(@Serice, @RestContorller, @Repository) IN ***com.unwanted*** are scanned by @ComponentScan");
	}
}
